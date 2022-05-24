package com.example.proyecto.servicio;

import com.example.proyecto.modelo.Nota;

import java.util.List;

public interface NotaServicio {
    Nota agregaNota(Integer idUsuario, String titulo, String texto);
    List<Nota> todas(Integer idUsuario);
}
