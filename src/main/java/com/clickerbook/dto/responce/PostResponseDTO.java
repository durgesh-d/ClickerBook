package com.clickerbook.dto.responce;

import com.clickerbook.constant.Visibility;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class PostResponseDTO {

    private Long id;

    private String username;

    private String profileImage;

    private String caption;

    private String description;

    private String location;

    private Visibility visibility;

    private List<String> imageUrls;

    private Long likeCount;

    private Long commentCount;

    private LocalDateTime createdAt;
}