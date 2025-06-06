package com.helix.gpo.projects_service.payload;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponse {
    //  ProjectDto (id, title, description, startDate, endDate, creationDate, lastUpdate, projectStatus, image, showOnWebsite, PartnerDto)

    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate creationDate;
    private LocalDate lastUpdate;
    private String status;
    private byte[] image;
    private Boolean showOnWebsite;

}
