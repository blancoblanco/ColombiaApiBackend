package com.ColombiaApi.jumatabaCo.controller;

import com.ColombiaApi.jumatabaCo.Repository.JpaUserRepository;
import com.ColombiaApi.jumatabaCo.jwt.JwtService;
import com.ColombiaApi.jumatabaCo.dto.AuthResponse;
import com.ColombiaApi.jumatabaCo.dto.LoginRequest;
import com.ColombiaApi.jumatabaCo.dto.RegisterRequest;
import com.ColombiaApi.jumatabaCo.model.Rol;
import com.ColombiaApi.jumatabaCo.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JpaUserRepository jpaUserRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNombre(), request.getContrasena()));
        
        UserDetails user = jpaUserRepository.findByNombre(request.getNombre())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        String token = jwtService.getToken(user);
        return AuthResponse.builder().token(token).build();
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .contrasena(passwordEncoder.encode(request.getContrasena()))
                .correo(request.getCorreo())
                .rol(Rol.ADMIN)
                .build();

        jpaUserRepository.save(usuario);
        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}