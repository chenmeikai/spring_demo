package com.kenhome.web.config.netty;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 17:58 2018/9/27 0027
 * @Modified By:
 */

@Getter
@Setter
@ConfigurationProperties(prefix = "netty")
public class NettyServer {

    /**
     * 端口
     */
    private int port;
    /**
     * 最大线程数
     */
    private int maxThreads;
    /**
     * 最大数据包长度
     */
    private int maxFrameLength;
}
