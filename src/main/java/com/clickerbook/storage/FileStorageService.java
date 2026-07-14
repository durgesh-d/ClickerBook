package com.clickerbook.storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileStorageService {
    List<String> uploadImages(
            MultipartFile[] files) throws IOException;
}
