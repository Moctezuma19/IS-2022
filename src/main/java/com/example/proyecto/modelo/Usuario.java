package com.example.proyecto.modelo;

import com.example.proyecto.util.Rol;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @OneToMany(mappedBy = "usuario", targetEntity = Nota.class)
    private List<Nota> notas = new ArrayList<>();
}
