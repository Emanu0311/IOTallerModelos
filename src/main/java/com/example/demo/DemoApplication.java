package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.adapters.DoubleInput;
import com.example.demo.adapters.DoubleInputAdapter;
import com.example.demo.adapters.IntegerInput;
import com.example.demo.adapters.IntegerInputAdapter;
import com.example.demo.factory.IOFactory;
import com.example.demo.factory.Input;
import com.example.demo.factory.Output;
import com.example.demo.factory.console.ConsoleIOFactory;
import com.example.demo.factory.frame.FrameIOFactory;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        

        while (true) {

            System.out.println("\nSeleccione el entorno de entrada/salida:");
            System.out.println("1. Consola");
            System.out.println("2. Frame (JOptionPane)");
            System.out.println("3. Web");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            int option = scanner.nextInt();

            switch (option) {

                case 1 -> ejecutarIO(new ConsoleIOFactory());

                case 2 -> ejecutarIO(new FrameIOFactory());

                case 3 -> {
                    System.out.println("Iniciando aplicación web...");
                    SpringApplication.run(DemoApplication.class, args);
                    return; // Spring toma el control
                }

                case 4 -> {
                    System.out.println("Saliendo...");
                    System.exit(0);
                }

                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void ejecutarIO(IOFactory factory) {
        Input input = factory.createInput();
        Output output = factory.createOutput();
        
        String tipo = input.readData(
            "Seleccione tipo de dato:\n1. Double\n2. Integer"
        );
        
        if (tipo == null) {
            return;
        }
        
        switch (tipo) {
            case "1" -> {
                DoubleInput doubleInput = new DoubleInputAdapter(input, output);
                double numero = doubleInput.getDoubleInput();
                output.writeData("Double ingresado correctamente: " + numero);
            }
            
            case "2" -> {
                IntegerInput integerInput = new IntegerInputAdapter(input, output);

                int numero = integerInput.getIntegerInput();
                output.writeData("Integer ingresado correctamente: " + numero);
            }
            default -> output.writeData("Opción inválida.");
        }
    }
}