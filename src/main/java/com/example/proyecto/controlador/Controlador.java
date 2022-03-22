package com.example.proyecto.controlador;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Controlador {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/procesa")
    public String procesa(HttpServletRequest request, Model model ) {
        String titulo = request.getParameter("titulo");
        String nota = request.getParameter("nota");
        System.out.println("titulo -> " + titulo);
        System.out.println("nota -> " + nota);
        model.addAttribute("titulo", titulo);
        model.addAttribute("nota", nota);
        return "final";
    }

}
