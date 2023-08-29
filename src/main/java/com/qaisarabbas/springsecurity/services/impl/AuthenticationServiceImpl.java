package com.qaisarabbas.springsecurity.services.impl;

/*
 * @created 27/08/2023 - 8:53 pm
 * @project springsecurity
 * @package com.qaisarabbas.springsecurity.services.impl
 * @author Qaisar Abbas
 */


import com.qaisarabbas.springsecurity.entites.UsersEntity;
import com.qaisarabbas.springsecurity.exceptions.GlobalException;
import com.qaisarabbas.springsecurity.models.requests.LoginRequest;
import com.qaisarabbas.springsecurity.models.requests.RegisterRequest;
import com.qaisarabbas.springsecurity.models.response.AuthResponse;
import com.qaisarabbas.springsecurity.repositories.UserRepository;
import com.qaisarabbas.springsecurity.services.AuthenticationService;
import com.qaisarabbas.springsecurity.services.JwtService;
import com.qaisarabbas.springsecurity.utils.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthResponse register(RegisterRequest request) {

        if (!request.getPassword().equals(request.getConfirmPassword())){
            throw new GlobalException("Your confirmed password not matched!");
        }else if (userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new GlobalException("Your email already exist!");
        }

        UsersEntity user = UsersEntity.builder()
                .name(request.getFullName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();

        userRepository.save(user);

        var jwt = jwtService.generateToken(user);

        return AuthResponse.builder().token(jwt).build();
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return AuthResponse.builder().token(jwt).build();
    }
}
