package com.example.demo;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Data //создает геттеры и сетторы для полей ( в нашем случае для поля)
@Component
public class HelloBean {
    private String string;
    @Autowired
    public HelloBean(String string) {
        this.string = string;
    }
    //Ну или так
//    public HelloBean(@Value("${hellobean.string}") String string) {
//        this.string = string;
//    }
}
