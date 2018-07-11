package com.reactlibrary.orvibo.devicesInterface;

/**
 * @Description 灯操作
 * @Author yongjian.chen
 * @Date 2018/7/9
 * @Version
 */

public interface IDevice<T> {
    /**
     * 开
     */
    void open(T object);

    /**
     * 关
     */
    void close(T object);
}
