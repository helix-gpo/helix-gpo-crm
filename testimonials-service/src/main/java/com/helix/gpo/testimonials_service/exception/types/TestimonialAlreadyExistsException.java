package com.helix.gpo.testimonials_service.exception.types;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class TestimonialAlreadyExistsException extends RuntimeException {
    public TestimonialAlreadyExistsException(Long projectId) {
        super(String.format("Testimonial already exists for project with ID: %s", projectId));
    }

}
