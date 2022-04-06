package com.example.proyecto.repositorio;

import com.example.proyecto.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    boolean existsUsuarioByNombre(String nombre);
    Usuario findByNombre(String nombre);
}
