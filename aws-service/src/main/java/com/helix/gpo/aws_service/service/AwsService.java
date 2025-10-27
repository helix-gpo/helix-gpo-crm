package com.helix.gpo.aws_service.service;

import org.springframework.web.multipart.MultipartFile;

public interface AwsService {

    String uploadImage(String bucket, MultipartFile image, String key);

    String generatePresignedUrl(String bucket, String key, String contentType);

    Boolean deleteImage(String bucket, String key);

}
