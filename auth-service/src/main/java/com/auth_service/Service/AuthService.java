package com.auth_service.Service;

import com.auth_service.Dto.LoginRequest;
import com.auth_service.Util.JwtUtil;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public Optional<String> authenticate(LoginRequest loginRequest){
        return userService.findByEmail(loginRequest.getEmail())
                .filter(user -> passwordEncoder.matches(loginRequest.getPassword(),
                        user.getPassword()))
                .map(user -> jwtUtil.generateToken(user.getEmail(), user.getRole()));
    }

    public boolean validateToken(String token){
        try {
            jwtUtil.validateToken(token);
            return true;
        } catch (JwtException exception){
            return false;
        }
    }
}
