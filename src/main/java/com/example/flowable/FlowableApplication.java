package com.example.flowable;

import com.example.flowable.demo.Context;
import com.example.flowable.demo.FlowEngine;
import com.example.flowable.demo.FlowNode;
import com.example.flowable.demo.TestMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@SpringBootApplication
public class FlowableApplication {

    @Autowired
    FlowEngine flowEngine;

    public static void main(String[] args) {
        SpringApplication.run(FlowableApplication.class, args);
    }


    @RequestMapping("/test")
    public String test() throws Exception {
        FlowNode testFlow = TestMain.Flow.getTestFlow();
        FlowEngine.RunData runData = new FlowEngine.RunData();
        runData.setParamOne("one");
        runData.setParamTwo("two");
        Context context = new Context();
        flowEngine.excute(testFlow, runData, context);
        Map<String, Object> resultMap = context.getResultMap();

        System.out.println("返回结果：");
        System.out.println(resultMap.get("NodeOne"));
        System.out.println(resultMap.get("NodeTwo"));
        return null;
    }

}
