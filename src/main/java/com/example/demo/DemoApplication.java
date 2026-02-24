package com.example.demo;

import com.example.demo.factory.IOFactory;
import com.example.demo.factory.Input;
import com.example.demo.factory.Output;
import com.example.demo.factory.console.ConsoleIOFactory;
import com.example.demo.factory.frame.FrameIOFactory;
import com.example.demo.factory.web.WebIOFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IOFactory factory = null;

		System.out.println("Seleccione el entorno de entrada/salida:");
		System.out.println("1. Consola");
		System.out.println("2. Frame (JOptionPane)");
		System.out.println("3. Web");
		System.out.print("Opción: ");
		int option = scanner.nextInt();

		switch (option) {
			case 1:
				factory = new ConsoleIOFactory();
				break;
			case 2:
				factory = new FrameIOFactory();
				break;
			case 3:
				System.out.println("Iniciando aplicación web...");
				System.out.println("Por favor abra su navegador web en http://localhost:3000/imputOuput");
				WebIOFactory webFactory = new WebIOFactory();
				webFactory.startSpringApplication(args);
				System.out.println("Servidor iniciado. Presione Ctrl+C para detenerlo.");
				// Skip the rest for web context
				scanner.close();
				return;
			default:
				System.out.println("Opción no válida.");
				System.exit(0);
		}

		Input input = factory.createInput();
		Output output = factory.createOutput();

		String data = input.readData("Ingrese un mensaje para enviar a la salida");
		output.writeData(data);

		scanner.close();
	}
}
