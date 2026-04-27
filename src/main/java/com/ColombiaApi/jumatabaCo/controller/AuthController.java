package com.ColombiaApi.jumatabaCo.controller;


import com.ColombiaApi.jumatabaCo.dto.AuthResponse;
import com.ColombiaApi.jumatabaCo.dto.LoginRequest;
import com.ColombiaApi.jumatabaCo.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@CrossOrigin(origins = "${ALLOWED_ORIGINS:http://localhost:5173}")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // Blacklist de tokens invalidados
    private static final Map<String, Boolean> tokenBlacklist = new ConcurrentHashMap<>();

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        if (token != null && !token.isEmpty()) {
            tokenBlacklist.put(token,
                    true);
        }
        return ResponseEntity.ok(Map.of("message",
                "Sesión cerrada exitosamente"));
    }

    public static boolean isTokenBlacklisted(String token) {
        return token != null && tokenBlacklist.containsKey(token);
    }
}