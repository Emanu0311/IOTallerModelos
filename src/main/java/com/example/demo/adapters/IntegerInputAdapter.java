package com.example.demo.adapters;

import com.example.demo.factory.Input;
import com.example.demo.factory.Output;

public class IntegerInputAdapter implements IntegerInput {

    private final Input input;
    private final Output output;

    public IntegerInputAdapter(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public int getIntegerInput() {

        while (true) {

            String data = input.readData("Please enter an integer:");

            if (data == null) {
                throw new IllegalArgumentException("Input cancelled");
            }

            try {
                return Integer.parseInt(data);
            } catch (NumberFormatException e) {
                output.writeData("Invalid integer. Try again.");
            }
        }
    }
}