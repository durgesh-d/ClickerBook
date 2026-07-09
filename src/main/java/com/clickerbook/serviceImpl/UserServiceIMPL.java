package com.clickerbook.serviceImpl;

import com.clickerbook.config.SecurityConfig;
import com.clickerbook.constant.Role;
import com.clickerbook.constant.Status;
import com.clickerbook.dto.request.UserRequestDTO;
import com.clickerbook.dto.responce.UserResponceDTO;
import com.clickerbook.entity.User;
import com.clickerbook.exception.EmailAlreadyExistsException;
import com.clickerbook.exception.UsernameAlreadyExistsException;
import com.clickerbook.repository.UserRepository;
import com.clickerbook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {

    private final UserRepository  userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponceDTO registerUser(UserRequestDTO userRequest) {

        if(userRepository.existsByUsername(userRequest.getUsername())) {
            throw new UsernameAlreadyExistsException("Username is already in use");
        }

        if(userRepository.existsByEmail(userRequest.getEmail())) {
            throw new EmailAlreadyExistsException("Email is already in use");
        }

        User user = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .mobileNumber(userRequest.getMobileNumber())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role(Role.USER)
                .status(Status.ACTIVE)
                .privateAccount(false)
                .build();

        User savedUser =  userRepository.save(user);

        return UserResponceDTO.builder()
                .id(savedUser.getId())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .mobileNumber(savedUser.getMobileNumber())
                .bio(savedUser.getBio())
                .profileImage(savedUser.getProfileImage())
                .coverImage(savedUser.getCoverImage())
                .privateAccount(savedUser.getPrivateAccount())
                .role(savedUser.getRole().name())
                .status(savedUser.getStatus().name())
                .createdAt(savedUser.getCreatedAt())
                .build();



    }
}
