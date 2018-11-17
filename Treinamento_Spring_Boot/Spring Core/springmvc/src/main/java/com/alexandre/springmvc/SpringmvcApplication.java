package com.alexandre.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringmvcApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringmvcApplication.class, args);
//        System.out.println("***************** Beans *****************");
//        System.out.println("Count: "+run.getBeanDefinitionCount());
//        for(String name : run.getBeanDefinitionNames()){
//            System.out.println(name);
//        }
//        System.out.println("***************** Finish beans *****************");

    }
}
