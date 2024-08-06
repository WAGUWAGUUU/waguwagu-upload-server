package com.example.upload_server.service;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final Storage storage;

    @Value("${spring.cloud.gcp.storage.bucket}") // application.yml에 써둔 bucket 이름
    private String bucketName;

    @Value("${spring.cloud.gcp.storage.project-id}")
    private String projectId;

    @Override
    public void updateStorePhotoInfo(Long storeId, MultipartFile input) throws IOException {
        String originalName = input.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String ext = input.getContentType();
        String fileName = uuid;

        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, fileName)
                .setContentType(ext)
                .build();

        try {
            storage.create(blobInfo, input.getInputStream());

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file", e);
        }
    }
}
