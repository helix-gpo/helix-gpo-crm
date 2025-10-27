package com.helix.gpo.aws_service.exception.types;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UploadFailedException  extends RuntimeException {

    public UploadFailedException(String message) {
        super(message);
    }

}
