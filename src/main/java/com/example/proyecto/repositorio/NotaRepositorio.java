package com.example.proyecto.repositorio;

import com.example.proyecto.dto.NotaDto;
import com.example.proyecto.modelo.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepositorio extends JpaRepository<Nota, Integer> {

    List<Nota> findAllByIdUsuario(Integer idUsuario);

    @Query("select n from Nota n where n.idUsuario = ?1")
    List<Nota> encuentraNotasPorIdUsuario(Integer idUsuario);

    @Query("select n from Nota n JOIN Usuario u ON u.idUsuario = n.idUsuario AND u.idUsuario = ?1")
    List<Nota> encuentraNotaPorIdUsuarioJoin(Integer idUsuario);

    @Query(value = "select n.* from Nota n where n.idUsuario = ?1", nativeQuery = true)
    List<Nota> encuentraNotasPorIdUsuarioSQLNativo(Integer idUsuario);

    @Query("select new com.example.proyecto.dto.NotaDto(n.titulo, n.texto, n.usuario.nombre)  from Nota n where n.idUsuario = ?1")
    List<NotaDto> encuentraNotasPorIdUsuarioCamposEspecificos(Integer idUsuario);
    //select n from Nota n where n.idUsuario in (select u.idUsuario from Usuario u where u.idUsuario = ?1)
}
