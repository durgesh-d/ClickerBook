package com.clickerbook.service;

import com.clickerbook.dto.request.UserRequestDTO;
import com.clickerbook.dto.responce.UserResponceDTO;

public interface UserService {

    UserResponceDTO registerUser(UserRequestDTO userRequest);
}
