package com.reactlibrary.orvibo.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author yongjian.chen
 * @Date 2018/7/9
 * @Version
 */

public class ThreadPoolUtil {
    static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    public static ExecutorService getInstance(){
        return cachedThreadPool;
    }
}
