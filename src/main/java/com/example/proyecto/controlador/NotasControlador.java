package com.example.proyecto.controlador;

import com.example.proyecto.repositorio.NotaRepositorio;
import com.example.proyecto.servicio.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("/notas")
public class NotasControlador {

    @Autowired
    private NotaServicio notaServicio;

    @Autowired
    private NotaRepositorio notaRepositorio;

    @RequestMapping("/")
    public String nuevaNota() {
        return "nueva_nota";
    }

    @PostMapping("/procesa")
    public String procesa(HttpServletRequest request, Model model, Principal principal) {
        notaServicio.agregaNota(
                principal.getName(),
                request.getParameter("titulo"),
                request.getParameter("nota"));
        model.addAttribute("notas", notaServicio.todas(principal.getName()));
        return "final";
    }


    @GetMapping("/spec")
    @ResponseBody
    public String notas_spec() {
        return notaRepositorio.encuentraNotasPorIdUsuarioCamposEspecificos(1).toString();
    }

}
