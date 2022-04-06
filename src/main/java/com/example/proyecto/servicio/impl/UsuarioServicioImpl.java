package com.example.proyecto.servicio.impl;

import com.example.proyecto.modelo.Usuario;
import com.example.proyecto.repositorio.UsuarioRepositorio;
import com.example.proyecto.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public Usuario creaUsuario(String nombre, String password){
        if (usuarioRepositorio.existsUsuarioByNombre(nombre)) {
            return null;
        }
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        nuevoUsuario.setPassword(passwordEncoder.encode(password));
        return usuarioRepositorio.save(nuevoUsuario);
    }
}
