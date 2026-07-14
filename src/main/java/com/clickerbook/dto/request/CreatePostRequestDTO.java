package com.clickerbook.dto.request;

import com.clickerbook.constant.Visibility;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreatePostRequestDTO {
    @NotBlank(message = "Caption is Required")
    private String caption;

    private String description;

    @NotBlank(message = "Location is required")
    private String location;

    private Visibility visibility =  Visibility.PUBLIC;
}
