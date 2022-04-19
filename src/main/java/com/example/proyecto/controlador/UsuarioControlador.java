package com.example.proyecto.controlador;

import com.example.proyecto.modelo.Usuario;
import com.example.proyecto.repositorio.UsuarioRepositorio;
import com.example.proyecto.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepositorio.findAll());
        return "usuarios";
    }

    @PostMapping("/crea")
    public String crea(HttpServletRequest request, Model model) {
        Usuario usuario = usuarioServicio.creaUsuario(request.getParameter("nombre"),
                request.getParameter("password"));
        model.addAttribute("exito", usuario != null);
        return "registro";
    }


}
