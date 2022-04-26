package com.example.proyecto.modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnota")
    private Integer idNota;
    @Column
    private String titulo;
    @Column
    private String texto;
    @Column(name = "idusuario")
    private Integer idUsuario;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", nullable = false, insertable = false, updatable = false)
    private Usuario usuario;
}
