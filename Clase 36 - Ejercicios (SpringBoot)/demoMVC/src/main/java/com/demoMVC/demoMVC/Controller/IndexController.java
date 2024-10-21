package com.demoMVC.demoMVC.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String indexH1(Model model) {
        String mensaje = "¡Hola, este mensaje viene desde el IndexController!";
        String mensaje2 = " Este es un proyecto Spring Boot MVC";
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("mensaje2", mensaje2);
        return "index";
    }
}
