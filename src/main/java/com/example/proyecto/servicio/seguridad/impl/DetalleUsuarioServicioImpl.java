package com.example.proyecto.servicio.seguridad.impl;

import com.example.proyecto.modelo.Usuario;
import com.example.proyecto.repositorio.UsuarioRepositorio;
import com.example.proyecto.servicio.seguridad.DetalleUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DetalleUsuarioServicioImpl implements DetalleUsuarioServicio, UserDetailsService {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuario usuarioActivo = usuarioRepositorio.findByNombre(nombre);
        if (usuarioActivo == null) {
            throw new UsernameNotFoundException("name not found");
        }
        UserDetails userDetails;
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioActivo.getRol().toString());
        userDetails = new User(usuarioActivo.getNombre(), usuarioActivo.getPassword(), Arrays.asList(grantedAuthority));
        return userDetails;
    }
}
