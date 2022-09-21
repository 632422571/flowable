package com.example.flowable.demo;

import org.springframework.stereotype.Service;

/**
 * 7、创建两个测试node节点
 */
@Service
public class NodeOne implements FlowNodeInterface {
    @Override
    public Object invokeNode(FlowEngine.RunData runData, Context context) {
        System.out.println("执行方法" + runData.getParamOne());
        return "nodeone的返回结果";
    }

    @Override
    public void afterInvoke(FlowEngine.RunData runData, Context context) {
        System.out.println("one 之后");
    }

    @Override
    public String resultKey() {
        return "NodeOne";
    }
}
