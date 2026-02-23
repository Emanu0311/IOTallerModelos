package com.example.demo.factory.web;

import com.example.demo.factory.Input;

public class WebInput implements Input {
    @Override
    public String readData(String prompt) {
        // Mock implementation for web input
        String mockValue = "Mock Web input for " + prompt;
        System.out.println("[Web Simulation] Reading data: " + mockValue);
        return mockValue;
    }
}
