package com.example.proyecto.controlador;

import com.example.proyecto.servicio.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/notas")
public class NotasControlador {

    @Autowired
    private NotaServicio notaServicio;

    @RequestMapping("/")
    public String nuevaNota(){
        return "nueva_nota";
    }

    @PostMapping("/procesa")
    public String procesa(HttpServletRequest request, Model model) {
        notaServicio.agregaNota(
                request.getParameter("titulo"), request.getParameter("nota"));
        model.addAttribute("notas", notaServicio.todas());
        return "final";
    }

}
