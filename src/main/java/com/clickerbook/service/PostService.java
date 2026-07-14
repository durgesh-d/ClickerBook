package com.clickerbook.service;

import com.clickerbook.dto.request.CreatePostRequestDTO;
import com.clickerbook.dto.responce.PostResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface PostService {

    PostResponseDTO createPost(CreatePostRequestDTO request, MultipartFile[] images);
}
