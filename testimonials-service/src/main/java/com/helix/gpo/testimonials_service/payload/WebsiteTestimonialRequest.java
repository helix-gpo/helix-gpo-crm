package com.helix.gpo.testimonials_service.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebsiteTestimonialRequest {

    @NotNull
    private TestimonialDtoRequest testimonialDtoRequest;

    @NotEmpty(message = "Authentifizierungscode darf nicht leer sein!")
    private String authTokenValue;

}
