package com.helix.gpo.company_service.exception.types;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private final String id;
    private final String resource;

    public ResourceNotFoundException(String message, String id, String resource) {
        super(message);

        this.id = id;
        this.resource = resource;
    }

}
