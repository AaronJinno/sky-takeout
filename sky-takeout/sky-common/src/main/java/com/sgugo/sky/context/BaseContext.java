package com.sgugo.sky.context;

public class BaseContext {
    // 创建ThreadLocal对象
    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 拦截器将JWT中解析的id,储存到当前线程中
     * @param id JWT中解析的id
     */
    public static void setId(Long id){
        threadLocal.set(id);
    }

    /**
     * 获取当前线程中保存的id
     */
    public static Long getId(){
        return threadLocal.get();
    }

    /**
     * 移除当前线程中的id，因为Spring会启动线程池，所以要手动移除
     */
    public static void removeId(){
        threadLocal.remove();
    }
}
