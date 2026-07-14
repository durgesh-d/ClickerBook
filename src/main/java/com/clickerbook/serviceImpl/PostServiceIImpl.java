package com.clickerbook.serviceImpl;

import com.clickerbook.dto.request.CreatePostRequestDTO;
import com.clickerbook.dto.responce.PostResponseDTO;
import com.clickerbook.entity.Post;
import com.clickerbook.entity.User;
import com.clickerbook.exception.UserNotFoundException;
import com.clickerbook.repository.PostRepository;
import com.clickerbook.repository.UserRepository;
import com.clickerbook.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PostServiceIImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public PostResponseDTO createPost(CreatePostRequestDTO request,
                                      MultipartFile[] images) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        Post post = Post.builder()
                .user(user)
                .caption(request.getCaption())
                .description(request.getDescription())
                .location(request.getLocation())
                .visibility(request.getVisibility())
                .build();

        Post savedPost = postRepository.save(post);

        return null;
    }

}
