package com.helix.gpo.projects_service.exception.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@AllArgsConstructor
@Getter
public class ProjectNotFoundException extends RuntimeException {

    private Long projectId;

}
