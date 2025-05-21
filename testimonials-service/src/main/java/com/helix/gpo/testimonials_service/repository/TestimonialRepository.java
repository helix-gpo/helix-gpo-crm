package com.helix.gpo.testimonials_service.repository;

import com.helix.gpo.testimonials_service.entity.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {

    List<Testimonial> findAllByShowOnWebsite(Boolean showOnWebsite);

}
