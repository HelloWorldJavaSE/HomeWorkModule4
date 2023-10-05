package com.example.demo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        HelloBean helloBean = context.getBean(HelloBean.class);
        System.out.println(helloBean.getString());
        context.close();
    }

}
