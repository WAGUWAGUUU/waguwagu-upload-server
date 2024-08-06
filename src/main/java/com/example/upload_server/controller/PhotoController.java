package com.example.upload_server.controller;

import com.example.upload_server.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/photo")
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;

    @PostMapping("/store/{storeId}")
    public void updateStorePhotoInfo(@PathVariable(name = "storeId") Long storeId,@RequestParam(name="file") MultipartFile file) throws IOException {
        photoService.updateStorePhotoInfo(storeId, file);
    }



}
