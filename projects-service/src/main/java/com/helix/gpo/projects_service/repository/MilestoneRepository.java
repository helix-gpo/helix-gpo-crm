package com.helix.gpo.projects_service.repository;

import com.helix.gpo.projects_service.entity.Milestone;
import com.helix.gpo.projects_service.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {

    List<Milestone> findAllByProject(Project project);

}
