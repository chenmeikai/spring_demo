package com.kenhome.web.config.netty;

import lombok.Data;

import java.io.Serializable;

/**
 * 服务器可能返回空的处理
 * <p>
 * @author cmk
 * @date 2018/9/27 - 21:55
 */
@Data
public class NullWritable implements Serializable {
    /**
     * 序列化标识
     */
    private static final long serialVersionUID = 2123827169429254101L;
    /**
     * 单例
     */
    private static NullWritable instance = new NullWritable();

    /**
     * 私有构造器
     */
    private NullWritable() {
    }

    public static NullWritable nullWritable() {
        return instance;
    }
}
