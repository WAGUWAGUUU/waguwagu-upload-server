package com.example.upload_server.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PhotoService {

    void updateStorePhotoInfo(Long storeId, MultipartFile input) throws IOException;

}
