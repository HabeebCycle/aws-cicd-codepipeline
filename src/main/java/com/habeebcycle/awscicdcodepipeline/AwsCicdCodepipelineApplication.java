package com.habeebcycle.awscicdcodepipeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@SpringBootApplication
public class AwsCicdCodepipelineApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsCicdCodepipelineApplication.class, args);
    }

    /*
    @Bean
    public RestTemplate getRestTemplate(){
        DefaultUriBuilderFactory builder = new DefaultUriBuilderFactory("http://localhost:8080");
        return new RestTemplateBuilder().uriTemplateHandler(builder).build();
    }
    */

}
