package com.example.flowable.demo;

import org.springframework.stereotype.Service;

/**
 * 7、创建两个测试node节点
 */
@Service
public class NodeTwo implements FlowNodeInterface {
    @Override
    public Object invokeNode(FlowEngine.RunData runData, Context context) {
        System.out.println("执行方法" + runData.getParamTwo());
        return runData.getParamTwo();
    }

    @Override
    public void afterInvoke(FlowEngine.RunData runData, Context context) {

    }

    @Override
    public String resultKey() {
        return "NodeTwo";
    }
}
