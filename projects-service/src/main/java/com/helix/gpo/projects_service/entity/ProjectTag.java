package com.helix.gpo.projects_service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProjectTag {

    PROCESS ("Prozessoptimierung", "#03dbff"),
    SOFTWARE ("Software & Web", "#0d1424"),
    MONITORING ("Monitoring & Steuerung", "#7f6fea"),
    STRATEGY ("Strategie & Entwicklung", "#fc03d5"),
    ;

    private final String value;
    private final String color;

}
