package com.example.proyecto.controlador;


import org.springframework.stereotype.Controller;
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
    public String procesa(HttpServletRequest request) {
        String dato = request.getParameter("dato");
        System.out.println("dato -> " + dato);
        return "index";
    }

}
