package com.example.demo.factory.frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.example.demo.factory.Output;

public class FrameOutput implements Output {
    @Override
    public void writeData(String data) {
        JOptionPane.showMessageDialog(
            new JFrame(),
            "Output (Frame): " + data
        );
    }
}
