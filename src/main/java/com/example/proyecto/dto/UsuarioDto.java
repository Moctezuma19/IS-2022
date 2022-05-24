package com.example.proyecto.dto;

import lombok.Data;

@Data
public class UsuarioDto {
    private Integer idUsuario;
    private String nombre;
    private String password;
    private String token;
}
