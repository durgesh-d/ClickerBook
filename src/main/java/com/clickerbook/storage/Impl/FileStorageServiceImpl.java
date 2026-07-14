package com.clickerbook.storage.Impl;

import com.clickerbook.storage.FileStorageService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public class FileStorageServiceImpl implements FileStorageService {
    @Override
    public List<String> uploadImages(MultipartFile[] files) throws IOException {
        return List.of();
    }
}
