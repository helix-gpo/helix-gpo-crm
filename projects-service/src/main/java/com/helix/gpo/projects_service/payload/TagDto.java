package com.helix.gpo.projects_service.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagDto {

    private String color;
    private String value;

}
