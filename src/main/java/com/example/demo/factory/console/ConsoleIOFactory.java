package com.example.demo.factory.console;

import com.example.demo.factory.IOFactory;
import com.example.demo.factory.Input;
import com.example.demo.factory.Output;

public class ConsoleIOFactory implements IOFactory {
    @Override
    public Input createInput() {
        return new ConsoleInput();
    }

    @Override
    public Output createOutput() {
        return new ConsoleOutput();
    }
}
