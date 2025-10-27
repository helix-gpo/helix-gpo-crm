package com.helix.gpo.aws_service.controller;

import com.helix.gpo.aws_service.service.AwsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/api/v1/aws/website")
@RequiredArgsConstructor
public class AwsController {

    private final AwsService awsService;

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam(name = "bucket") String bucket,
                                              @RequestPart(name = "image") MultipartFile file,
                                              @RequestParam(name = "key") String key) {
        return new ResponseEntity<>(awsService.uploadImage(bucket, file, key), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> getPresignedUrl(@RequestParam(name = "bucket") String bucket,
                                                  @RequestParam(name = "key") String key,
                                                  @RequestParam(name = "contentType") String contentType) {
        return new ResponseEntity<>(awsService.generatePresignedUrl(bucket, key, contentType), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestParam(name = "bucket") String bucket,
                                          @RequestParam(name = "key") String key) {
        return new ResponseEntity<>(awsService.deleteImage(bucket, key), HttpStatus.OK);
    }

}
