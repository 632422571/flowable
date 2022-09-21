package com.example.flowable.demo;

/**
 * 最后，创建两个节点NodeOne 和NodeTwo 作为模拟真实业务场景的节点，
 * 通过一个后面的three作为一个group 需要并行执行的节点
 */
public class TestMain {


/*    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        FlowNode testFlow = Flow.getTestFlow();
        FlowEngine flowEngine = (FlowEngine) applicationContext.getBean("flowEngine");
        FlowEngine.RunData runData = new FlowEngine.RunData();
        runData.setParamOne("one");
        runData.setParamTwo("two");
        Context context = new Context();
        flowEngine.excute(testFlow, runData, context);
        Map<String, Object> resultMap = context.getResultMap();

        System.out.println(resultMap.get("NodeOne"));
        System.out.println(resultMap.get("NodeTwo"));
    }*/

    public static class Flow {
        private static FlowNode testFlow = new FlowNode();
        static {
            testFlow.add(NodeOne.class, new FlowNode.NodeConf());
            testFlow.add(NodeTwo.class, new FlowNode.NodeConf());
            testFlow.add("three", NodeOne.class, new FlowNode.NodeConf());
            testFlow.add("three", NodeTwo.class, new FlowNode.NodeConf());
        }
        public static FlowNode getTestFlow() {
            return testFlow;
        }
    }
}
