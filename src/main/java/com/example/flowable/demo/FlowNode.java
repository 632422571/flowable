package com.example.flowable.demo;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 2、创建我们的流程节点，这相当于就是保存我们整个流程中需要执行下游服务的节点，
 * 以Map作为保存数据，NodeConf 节点设置参数，
 * 自定义请求服务超时时间（因为并行我们是用的线程池或者通过get设置时间get返回值结果）
 */
public class FlowNode {

    private Map<String, NodeConf> nodeMap = new LinkedHashMap<>();

    public Map<String, NodeConf> getNodeMap() {
        return nodeMap;
    }

    public Set<String> getNodeList() {
        return nodeMap.keySet();
    }

    public void setNodeMap(LinkedHashMap<String, NodeConf> nodeMap) {
        this.nodeMap = nodeMap;
    }

    public void add(String groupName, Class nobeName, NodeConf nodeConf) {
        String key = null;
        if (null != groupName && !"".equals(groupName)) {
            key = groupName + "_" + nobeName.getName();
        }else {
            key = nobeName.getName();
        }

        if (nodeMap.containsKey(key)) {
            return;
        }

        nodeMap.put(key, nodeConf);
    }

    public void add(Class nobeName, NodeConf nodeConf) {
        add(nobeName.getName(), nobeName, nodeConf);
    }

    public void replace(String groupName, Class nobeName, NodeConf nodeConf) {
        String key = null;
        if (null != groupName && !"".equals(groupName)) {
            key = groupName + "_" + nobeName.getName();
        }else {
            key = nobeName.getName();
        }

        nodeMap.put(key, nodeConf);
    }

    public void replace(Class nobeName, NodeConf nodeConf) {
        replace(nobeName.getName(), nobeName, nodeConf);
    }

    public void remove(String groupName, Class nobeName) {
        String key = null;
        if (null != groupName && !"".equals(groupName)) {
            key = groupName + "_" + nobeName.getName();
        }else {
            key = nobeName.getName();
        }

        nodeMap.remove(key);
    }

    public void remove(Class nobeName) {
        remove(nobeName.getName(), nobeName);
    }

    public static class NodeConf {

        private int timeOut = 100;

        public NodeConf() {}

        public NodeConf(int timeOut) {
            this.timeOut = timeOut;
        }

        public int getTimeOut() {
            return timeOut;
        }

        public void setTimeOut(int timeOut) {
            this.timeOut = timeOut;
        }

    }
}
