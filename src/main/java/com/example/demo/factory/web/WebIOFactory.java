package com.example.demo.factory.web;

import com.example.demo.DemoApplication;
import com.example.demo.factory.IOFactory;
import com.example.demo.factory.Input;
import com.example.demo.factory.Output;
import org.springframework.boot.SpringApplication;

public class WebIOFactory implements IOFactory {
    @Override
    public Input createInput() {
        return new WebInput();
    }

    @Override
    public Output createOutput() {
        return new WebOutput();
    }

    public void startSpringApplication(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
