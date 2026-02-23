package com.example.demo.factory.frame;

import com.example.demo.factory.Input;
import javax.swing.JOptionPane;

public class FrameInput implements Input {
    @Override
    public String readData(String prompt) {
        return JOptionPane.showInputDialog(null, prompt);
    }
}
