package com.example.proyecto.servicio.impl;

import com.example.proyecto.modelo.Nota;
import com.example.proyecto.repositorio.NotaRepositorio;
import com.example.proyecto.servicio.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServicioImpl implements NotaServicio {

    @Autowired
    private NotaRepositorio notaRepositorio;

    @Override
    public Nota agregaNota(String titulo, String texto) {
        Nota nota = new Nota();
        nota.setTitulo(titulo);
        nota.setTexto(texto);
        return notaRepositorio.save(nota);
    }

    @Override
    public List<Nota> todas() {
        return notaRepositorio.findAll();
    }
}
