package com.kenhome.web.config.netty;

import com.kenhome.web.utils.ObjectCodec;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Netty服务器监听器
 *
 * @author cmk
 * @date 2018/9/27 - 12:26
 */
@Component
@Slf4j
public class NettyServerListener {

    /**
     * 创建bootstrap
     */
    private ServerBootstrap serverBootstrap = new ServerBootstrap();
    /**
     * BOSS
     */
    private EventLoopGroup boss = new NioEventLoopGroup();
    /**
     * Worker
     */
    private EventLoopGroup work = new NioEventLoopGroup();
    /**
     * 通道适配器
     */
    @Resource
    private ServerChannelHandlerAdapter channelHandlerAdapter;
    /**
     * NETT服务器配置类
     */
    @Resource
    private NettyServer nettyServer;

    /**
     * 关闭服务器方法
     */
    @PreDestroy
    public void close() {
        log.info("关闭服务器....");
        //优雅退出
        boss.shutdownGracefully();
        work.shutdownGracefully();
    }

    /**
     * 开启及服务线程
     */
    public void start() {

        int port = nettyServer.getPort();
        serverBootstrap.group(boss, work)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 100)
                .handler(new LoggingHandler(LogLevel.INFO));
        try {
            //设置事件处理
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(new LengthFieldBasedFrameDecoder(nettyServer.getMaxFrameLength()
                            , 0, 2, 0, 2));
                    pipeline.addLast(new LengthFieldPrepender(2));
                    pipeline.addLast(new ObjectCodec());
                    pipeline.addLast(channelHandlerAdapter);
                }
            });
            log.info("netty服务器在[{}]端口启动监听", port);
            ChannelFuture f = serverBootstrap.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.info("[出现异常] 释放资源");
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }
}
