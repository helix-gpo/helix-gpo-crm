package com.helix.gpo.projects_service.payload.crm;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrmProjectDto {

    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate creationDate;
    private LocalDate lastUpdate;
    private String status;
    private BigDecimal price;
    private byte[] image;
    private Boolean showOnWebsite;

}
