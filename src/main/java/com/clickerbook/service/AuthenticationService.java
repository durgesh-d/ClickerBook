package com.clickerbook.service;

import com.clickerbook.dto.request.LoginRequestDTO;
import com.clickerbook.dto.responce.LoginResponseDTO;

public interface AuthenticationService {
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
