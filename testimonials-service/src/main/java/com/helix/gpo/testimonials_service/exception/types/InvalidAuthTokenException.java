package com.helix.gpo.testimonials_service.exception.types;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class InvalidAuthTokenException extends RuntimeException {

    public InvalidAuthTokenException(String message) {
        super(message);
    }

}
