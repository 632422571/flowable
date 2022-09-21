package com.example.flowable.demo;

/**
 * 5、创建节点接口，这里我们要定义一个ResultKey，
 * 这个Key也就是跟我流程中的这个节点所绑定，在获取数据的时候也就是通过者key来标识
 */
public interface FlowNodeInterface<T> {

    /**
     * node的执行方法
     */
    T invokeNode(FlowEngine.RunData runData, Context context);

    /**
     * node执行完之后的方法
     */
    void afterInvoke(FlowEngine.RunData runData, Context context);

    /**
     * 从context中获取此node结果的key
     */
    String resultKey();
}
