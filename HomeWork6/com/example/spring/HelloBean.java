package com.example.spring;

import lombok.Data;

@Data // CОздает для всех полей геторы и сеторы
public class HelloBean {
    private String line;

    public HelloBean(String line) {
        this.line = line;
    }
}
