package com.helix.gpo.testimonials_service.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestimonialDtoRequest {

    private Long id;

    @NotEmpty(message = "Der Titel darf nicht leer sein!")
    @Size(max = 30, message = "Der Titel darf nicht mehr als 30 Zeichen enthalten!")
    private String title;

    @NotEmpty(message = "Der Titel darf nicht leer sein!")
    @Size(max = 300, message = "Die Beschreibung darf nicht mehr als 300 Zeichen enthalten!")
    private String description;

    @NotNull
    @Size(min = 1, max = 5, message = "Das Rating muss 1 bis 5 Sterne haben!")
    private Integer result;

    @NotNull
    private Boolean showOnWebsite;

}
