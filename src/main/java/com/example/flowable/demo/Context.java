package com.example.flowable.demo;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.AnnotatedArrayType;
import java.util.HashMap;
import java.util.Map;

/**
 * 1、创建一个Context 上下文，作为我们的调用下游服务的返回结果
 */
public class Context {
    /**
     * 结果缓存
     */
    private Map<String, Object> resultMap = new HashMap<>();

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
}
