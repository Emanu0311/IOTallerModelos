package com.example.demo.factory.web;

import com.example.demo.factory.Output;

public class WebOutput implements Output {
    @Override
    public void writeData(String data) {
        // Mock implementation for web output
        System.out.println("Output (Web Simulation): " + data);
    }
}
