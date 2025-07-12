package com.helix.gpo.projects_service.service.impl;

import com.helix.gpo.projects_service.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;

import java.io.IOException;
import java.time.Duration;

@Service
@RequiredArgsConstructor
public class AwsS3ServiceImpl implements AwsS3Service {

    private final S3Client s3Client;
    private final S3Presigner s3Presigner;

    @Value("${aws.bucket}")
    private String bucket;

    @Override
    public String upload(MultipartFile image, String key) {
        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .contentType(image.getContentType())
                    .build();
            s3Client.putObject(putObjectRequest, RequestBody.fromBytes(image.getBytes()));
            return key;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String generatePresignedUrl(String key, String contentType) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .contentType(contentType)
                .build();
        PresignedPutObjectRequest presignedRequest = s3Presigner.presignPutObject(presignRequest -> presignRequest
                .putObjectRequest(putObjectRequest)
                .signatureDuration(Duration.ofDays(5))
        );
        return presignedRequest.url().toString();
    }

    @Override
    public void deleteImage(String key) {
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .build();
        s3Client.deleteObject(deleteObjectRequest);
    }

}
