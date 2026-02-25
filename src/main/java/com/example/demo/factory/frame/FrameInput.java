package com.example.demo.factory.frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.example.demo.factory.Input;

public class FrameInput implements Input {

    private static final JFrame frame = new JFrame();

    @Override
    public String readData(String prompt) {
        System.out.println("USANDO FRAME INPUT");
        frame.setAlwaysOnTop(true);

        return JOptionPane.showInputDialog(frame, prompt);
    }
}
