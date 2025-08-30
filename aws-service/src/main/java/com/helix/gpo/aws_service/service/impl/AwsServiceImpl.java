package com.helix.gpo.aws_service.service.impl;

import com.helix.gpo.aws_service.exception.types.UploadFailedException;
import com.helix.gpo.aws_service.service.AwsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

import java.io.IOException;
import java.time.Duration;

@Service
@RequiredArgsConstructor
public class AwsServiceImpl implements AwsService {

    private final S3Client s3Client;
    private final S3Presigner s3Presigner;

    @Override
    public String uploadImage(String bucket, MultipartFile image, String key) {
        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .contentType(image.getContentType())
                    .build();
            s3Client.putObject(putObjectRequest, RequestBody.fromBytes(image.getBytes()));
            return key;
        } catch (IOException e) {
            throw new UploadFailedException("");
        }
    }

    @Override
    public String generatePresignedUrl(String bucket, String key, String contentType) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .build();
        PresignedGetObjectRequest presignedRequest = s3Presigner.presignGetObject(presignRequest -> presignRequest
                .getObjectRequest(getObjectRequest)
                .signatureDuration(Duration.ofHours(5))
                .build()
        );
        return presignedRequest.url().toString();
    }

    @Override
    public Boolean deleteImage(String bucket, String key) {
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .build();
        s3Client.deleteObject(deleteObjectRequest);
        return true;
    }

}
