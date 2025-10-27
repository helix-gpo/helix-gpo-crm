package com.helix.gpo.projects_service.repository;

import com.helix.gpo.projects_service.entity.Project;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByShowOnWebsite(Boolean showOnWebsite, Sort sort);

    Optional<Project> findByTitle(String title);

}
