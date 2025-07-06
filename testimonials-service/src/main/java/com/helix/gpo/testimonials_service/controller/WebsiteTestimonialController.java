package com.helix.gpo.testimonials_service.controller;

import com.helix.gpo.testimonials_service.payload.TestimonialDtoResponse;
import com.helix.gpo.testimonials_service.payload.WebsiteTestimonialRequest;
import com.helix.gpo.testimonials_service.service.WebsiteTestimonialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/website/testimonials")
@RequiredArgsConstructor
public class WebsiteTestimonialController {

    private final WebsiteTestimonialService websiteTestimonialService;

    // todo: move endpoint to secure service later on!
    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<TestimonialDtoResponse> addTestimonial(@RequestPart(name = "payload") WebsiteTestimonialRequest websiteTestimonialRequest,
                                                                 @RequestPart(name = "image", required = false) MultipartFile image) {
        return new ResponseEntity<>(websiteTestimonialService.addTestimonial(websiteTestimonialRequest, image), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestimonialDtoResponse>> getAllWebsiteTestimonials() {
        return new ResponseEntity<>(websiteTestimonialService.getAllWebsiteTestimonials(), HttpStatus.OK);
    }

    @GetMapping(value = "/average")
    public ResponseEntity<BigDecimal> getAllWebsiteTestimonialsAverage() {
        return new ResponseEntity<>(websiteTestimonialService.getTestimonialsResultAverage(), HttpStatus.OK);
    }

}
