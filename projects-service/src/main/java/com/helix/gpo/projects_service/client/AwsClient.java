package com.helix.gpo.projects_service.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

public interface AwsClient {

    @PostExchange(value = "/api/v1/aws/website")
    String uploadImage(@RequestParam(name = "bucket") String bucket,
                       @RequestPart(name = "image") MultipartFile image,
                       @RequestParam(name = "key") String key);

    @GetExchange(value = "/api/v1/aws/website")
    String generatePresignedUrl(@RequestParam(name = "bucket") String bucket,
                                @RequestParam(name = "key") String key,
                                @RequestParam(name = "contentType") String contentType);

    @DeleteExchange(value = "/api/v1/aws/website")
    Boolean delete(@RequestParam(name = "bucket") String bucket,
                   @RequestParam(name = "key") String key);

}
