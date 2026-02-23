package com.example.demo.factory.console;

import com.example.demo.factory.Input;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String readData(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }
}
