package com.helix.gpo.testimonials_service.service;

import org.springframework.web.multipart.MultipartFile;

public interface AwsS3Service {

    String upload(MultipartFile image, String key);

    String generatePresignedUrl(String key, String contentType);

    void deleteImage(String key);

}
