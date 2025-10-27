package com.helix.gpo.projects_service.entity;

import com.helix.gpo.projects_service.entity.status.ProjectStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private LocalDate lastUpdate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectStatus status;

    private BigDecimal price;
    private String imageUrl;
    private String contentType;

    @Column(nullable = false)
    private Boolean showOnWebsite;

    @Column(nullable = false)
    private Long partnerId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
    private List<Milestone> milestones;

    @ElementCollection(targetClass = ProjectTag.class)
    @CollectionTable(
            name = "project_tags",
            joinColumns = @JoinColumn(name = "project_id")
    )
    @Column(name = "tag", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<ProjectTag> projectTags;

}
