package com.example.demo.adapters;

import com.example.demo.factory.Input;
import com.example.demo.factory.Output;

public class DoubleInputAdapter implements DoubleInput {

    private final Input input;
    private final Output output;

    public DoubleInputAdapter(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public double getDoubleInput() {

        while (true) {

            String stringInput = input.readData("Please enter a double:");

            if (stringInput == null) {
                throw new IllegalArgumentException("Input cancelled");
            }

            try {
                return Double.parseDouble(stringInput);
            } catch (NumberFormatException e) {
                // Volver a intentar
                output.writeData("Invalid double. Please try again.");
            }
        }
    }
}
