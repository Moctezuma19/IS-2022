package com.example.proyecto.controlador;

import com.example.proyecto.dto.UsuarioDto;
import com.example.proyecto.modelo.Usuario;
import com.example.proyecto.repositorio.UsuarioRepositorio;
import com.example.proyecto.seguridad.JWTProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class PrincipalControlador {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTProvider jwtProvider;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @PostMapping("/genera-token")
    public ResponseEntity<?> generateToken(@RequestBody UsuarioDto loginUser) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getNombre(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Usuario user = usuarioRepositorio.findByNombre(loginUser.getNombre());
        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        final String token = jwtProvider.doGenerateToken(user.getNombre());
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setIdUsuario(user.getIdUsuario());
        usuarioDto.setNombre(user.getNombre());
        usuarioDto.setToken(token);

        return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
    }

}
