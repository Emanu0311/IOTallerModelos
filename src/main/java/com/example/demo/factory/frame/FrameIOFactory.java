package com.example.demo.factory.frame;

import com.example.demo.factory.IOFactory;
import com.example.demo.factory.Input;
import com.example.demo.factory.Output;

public class FrameIOFactory implements IOFactory {
    @Override
    public Input createInput() {
        return new FrameInput();
    }

    @Override
    public Output createOutput() {
        return new FrameOutput();
    }
}
