package com.example.demo.factory.console;

import com.example.demo.factory.Output;

public class ConsoleOutput implements Output {
    @Override
    public void writeData(String data) {
        System.out.println("Output (Console): " + data);
    }
}
