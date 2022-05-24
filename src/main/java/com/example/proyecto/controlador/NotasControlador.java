package com.example.proyecto.controlador;

import com.example.proyecto.dto.NotaDto;
import com.example.proyecto.modelo.Nota;
import com.example.proyecto.repositorio.NotaRepositorio;
import com.example.proyecto.servicio.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotasControlador {

    @Autowired
    private NotaServicio notaServicio;

    @Autowired
    private NotaRepositorio notaRepositorio;

    @PostMapping("/agrega/{idUsuario}")
    public Nota agrega(HttpServletRequest request, @PathVariable Integer idUsuario) {
        return notaServicio.agregaNota(
                idUsuario,
                request.getParameter("titulo"),
                request.getParameter("nota"));
    }

    @GetMapping("/spec")
    public List<NotaDto> notas_spec() {
        return notaRepositorio.encuentraNotasPorIdUsuarioCamposEspecificos(1);
    }

}
