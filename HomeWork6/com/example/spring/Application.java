package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {


        public static void main(String[] args) {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            HelloBean helloBean = context.getBean("helloBean", HelloBean.class);
            System.out.println(helloBean.getLine());
            context.close();
        }


}
