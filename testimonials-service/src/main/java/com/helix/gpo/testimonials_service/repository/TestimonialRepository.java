package com.helix.gpo.testimonials_service.repository;

import com.helix.gpo.testimonials_service.entity.Testimonial;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {

    List<Testimonial> findAllByShowOnWebsite(Boolean showOnWebsite, Sort sort);

    Optional<Testimonial> findByProjectId(Long projectId);

}
