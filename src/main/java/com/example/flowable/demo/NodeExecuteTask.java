package com.example.flowable.demo;

import java.util.concurrent.Callable;

/**
 * 4、执行Call方法，也就是执行我们的node节点。
 */
public class NodeExecuteTask implements Callable {

    private FlowNodeInterface flowNodeInterface;
    private FlowEngine.RunData runData;
    private Context context;

    public NodeExecuteTask(FlowNodeInterface flowNodeInterface, FlowEngine.RunData runData, Context context) {
        this.flowNodeInterface = flowNodeInterface;
        this.runData = runData;
        this.context = context;
    }

    public Object execute() {
        try {
            Object o = flowNodeInterface.invokeNode(runData, context);
            flowNodeInterface.afterInvoke(runData, context);
            return o;
        } catch (Throwable e) {
            throw e;
        }
    }

    @Override
    public Object call() throws Exception {
        return execute();
    }
}
