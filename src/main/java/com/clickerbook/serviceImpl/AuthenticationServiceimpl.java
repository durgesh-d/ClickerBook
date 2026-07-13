package com.clickerbook.serviceImpl;

import com.clickerbook.dto.request.LoginRequestDTO;
import com.clickerbook.dto.responce.LoginResponseDTO;
import com.clickerbook.entity.User;
import com.clickerbook.exception.UserNotFoundException;
import com.clickerbook.repository.UserRepository;
import com.clickerbook.security.JwtService;
import com.clickerbook.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceimpl implements AuthenticationService {

    private final UserRepository  userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new UserNotFoundException("Invalid Username or Password"));

        if(!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
            throw new UserNotFoundException("Invalid Username or Password");
        }
        String token = jwtService.generateToken(user.getEmail());

        return LoginResponseDTO.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .build();
    }
}
