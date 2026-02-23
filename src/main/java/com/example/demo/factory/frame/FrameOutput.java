package com.example.demo.factory.frame;

import com.example.demo.factory.Output;
import javax.swing.JOptionPane;

public class FrameOutput implements Output {
    @Override
    public void writeData(String data) {
        JOptionPane.showMessageDialog(null, "Output (Frame): " + data);
    }
}
