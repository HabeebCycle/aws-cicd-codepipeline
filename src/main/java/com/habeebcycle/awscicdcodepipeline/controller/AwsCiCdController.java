package com.habeebcycle.awscicdcodepipeline.controller;

import com.habeebcycle.awscicdcodepipeline.model.AwsBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AwsCiCdController {

    @GetMapping
    public String startUp(){
        return "UP";
    }

    @GetMapping("/aws-bean/{versionId}")
    public ResponseEntity<?> getBean1(@PathVariable int versionId){
        AwsBean bean = new AwsBean(versionId, "AWS CodePipeline CI-CD Example", "AWS-Cloud",
                "Habeeb Okunade", "0.0.1-SNAPSHOT", new Date(System.currentTimeMillis()));
        return ResponseEntity.ok(bean);
    }

    @GetMapping("/aws-bean-2/{versionId}")
    public ResponseEntity<?> getBean2(@PathVariable int versionId){
        AwsBean bean = new AwsBean(versionId, "AWS CodePipeline CI-CD Example", "AWS-Cloud",
                "Habeeb Okunade", "0.0.2-SNAPSHOT", new Date(System.currentTimeMillis()));
        return ResponseEntity.ok(bean);
    }

    @GetMapping("/aws-bean-3/{versionId}")
    public ResponseEntity<?> getBean3(@PathVariable int versionId){
        AwsBean bean = new AwsBean(versionId, "AWS CodePipeline CI-CD Example", "AWS-Cloud",
                "Habeeb Okunade", "0.0.3-SNAPSHOT", new Date(System.currentTimeMillis()));
        return ResponseEntity.ok(bean);
    }
}
