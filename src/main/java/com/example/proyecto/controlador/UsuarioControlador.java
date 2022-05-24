package com.example.proyecto.controlador;

import com.example.proyecto.dto.UsuarioDto;
import com.example.proyecto.modelo.Usuario;
import com.example.proyecto.repositorio.UsuarioRepositorio;
import com.example.proyecto.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/todos")
    public List<Usuario> usuarios() {
        return usuarioRepositorio.findAll();
    }

    @PostMapping("/crea")
    public Usuario crea(@RequestBody UsuarioDto usuarioDto) {
        return usuarioServicio.creaUsuario(
                usuarioDto.getNombre(),
                usuarioDto.getPassword());
    }
}
