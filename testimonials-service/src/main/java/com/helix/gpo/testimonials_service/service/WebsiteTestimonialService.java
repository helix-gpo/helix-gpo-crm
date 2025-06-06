package com.helix.gpo.testimonials_service.service;

import com.helix.gpo.testimonials_service.payload.TestimonialDtoResponse;
import com.helix.gpo.testimonials_service.payload.WebsiteTestimonialRequest;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

public interface WebsiteTestimonialService {

    TestimonialDtoResponse addTestimonial(WebsiteTestimonialRequest testimonialRequest, MultipartFile image);

    List<TestimonialDtoResponse> getAllWebsiteTestimonials();

    BigDecimal getTestimonialsResultAverage();

}
