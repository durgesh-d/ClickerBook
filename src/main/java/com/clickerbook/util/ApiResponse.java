package com.clickerbook.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
    private boolean success;

    private String message;

    private int status;

    private T data;

    private Map<String, String> errors;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
