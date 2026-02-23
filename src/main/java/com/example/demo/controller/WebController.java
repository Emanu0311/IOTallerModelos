package com.example.demo.controller;

import com.example.demo.factory.IOFactory;
import com.example.demo.factory.web.WebIOFactory;
import com.example.demo.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    private final IOFactory factory = new WebIOFactory();

    @GetMapping("/imputOuput")
    public String showForm(Model model) {
        model.addAttribute("message", new Message());
        return "imputOuput";
    }

    @PostMapping("/imputOuput")
    public String processForm(@ModelAttribute Message message, Model model) {
        // En un caso real usaríamos la fábrica, aquí hacemos un eco simple del mensaje
        // para demostrar el funcionamiento del modelo y la vista
        message.setResponse("Recibido via Web: " + message.getContent());
        model.addAttribute("message", message);
        return "imputOuput";
    }
}
