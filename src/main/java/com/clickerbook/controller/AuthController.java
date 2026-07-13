package com.clickerbook.controller;

import com.clickerbook.dto.request.LoginRequestDTO;
import com.clickerbook.dto.responce.LoginResponseDTO;
import com.clickerbook.service.AuthenticationService;
import com.clickerbook.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDTO>> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO response = authenticationService.login(loginRequestDTO);

        ApiResponse<LoginResponseDTO> apiResponse =   ApiResponse.<LoginResponseDTO>builder()
                .success(true)
                .message("Login Successful")
                .status(HttpStatus.OK.value())
                .data(response)
                .build();

        return ResponseEntity.ok(apiResponse);
    }
}
