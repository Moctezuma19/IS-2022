package com.example.proyecto.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "Usuario")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idUsuario;
    @Column
    private String nombre;
    @Column
    private String password;
}
