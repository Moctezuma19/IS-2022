package com.example.proyecto.servicio;

import com.example.proyecto.modelo.Usuario;

public interface UsuarioServicio {
    Usuario creaUsuario(String nombre, String password);
}
