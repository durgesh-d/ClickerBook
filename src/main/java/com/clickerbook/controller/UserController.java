package com.clickerbook.controller;

import com.clickerbook.dto.request.UserRequestDTO;
import com.clickerbook.dto.responce.UserResponceDTO;
import com.clickerbook.service.UserService;

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
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponceDTO>> register(
            @Valid @RequestBody UserRequestDTO userRequest) {

        UserResponceDTO responseDTO = service.registerUser(userRequest);

        ApiResponse<UserResponceDTO> response = ApiResponse.<UserResponceDTO>builder()
                .success(true)
                .message("User registered successfully")
                .status(HttpStatus.CREATED.value())
                .data(responseDTO)
                .build();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
