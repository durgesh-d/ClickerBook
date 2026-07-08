package com.clickerbook.controller;

import com.clickerbook.dto.request.UserRequestDTO;
import com.clickerbook.dto.responce.UserResponceDTO;
import com.clickerbook.entity.User;
import com.clickerbook.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
    public ResponseEntity<UserResponceDTO> register(@RequestBody UserRequestDTO userRequest) {
        UserResponceDTO responceDTO = service.registerUser(userRequest);
        return new ResponseEntity<>(responceDTO,HttpStatus.CREATED);

    }
}
