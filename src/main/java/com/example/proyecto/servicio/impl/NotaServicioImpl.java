package com.example.proyecto.servicio.impl;

import com.example.proyecto.modelo.Nota;
import com.example.proyecto.modelo.Usuario;
import com.example.proyecto.repositorio.NotaRepositorio;
import com.example.proyecto.repositorio.UsuarioRepositorio;
import com.example.proyecto.servicio.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotaServicioImpl implements NotaServicio {

    @Autowired
    private NotaRepositorio notaRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public Nota agregaNota(Integer idUsuario, String titulo, String texto) {
        Usuario usuario = usuarioRepositorio.findById(idUsuario).orElse(null);
        if (usuario == null) {
            return null;
        }
        Nota nota = new Nota();
        nota.setTitulo(titulo);
        nota.setTexto(texto);
        nota.setIdUsuario(usuario.getIdUsuario());
        nota.setUsuario(usuario);
        return notaRepositorio.save(nota);
    }

    @Override
    public List<Nota> todas(Integer idUsuario) {
        Usuario usuario = usuarioRepositorio.findById(idUsuario).orElse(null);
        if (usuario == null) {
            return new ArrayList<>();
        }
        return usuario.getNotas();
    }
}
