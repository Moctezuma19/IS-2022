package com.example.proyecto.seguridad;

import io.jsonwebtoken.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Component
public class JWTProvider implements Serializable {
    static final Logger LOG = LogManager.getLogger(JWTProvider.class);

    @Value("${jwt.security.key}")
    private String jwtKey;

    /*@Value("${jwt.refreshExpirationDateInMs}")
    private int refreshExpirationDateInMs;*/

    public String doGenerateToken(String subject) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        Claims claims = Jwts.claims().setSubject(subject);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("http://jwtdemo.com")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(cal.getTimeInMillis()))
                .signWith(SignatureAlgorithm.HS256, jwtKey)
                .compact();
    }

    /*public String doGenerateRefreshToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + refreshExpirationDateInMs))
                .signWith(SignatureAlgorithm.HS256, jwtKey).compact();
    }*/

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsernameFromToken(String token) {
        final Claims claims = getAllClaimsFromToken(token);
        return claims.getSubject();
    }

    public Boolean validateToken(String token, String nombre) {
        final Claims claims = getAllClaimsFromToken(token);
        LOG.info("claims.getExpiration(): " + claims.getExpiration());
        return ( claims.getSubject().equals(nombre)
                        && !claims.getExpiration().before(new Date()));
    }
}
