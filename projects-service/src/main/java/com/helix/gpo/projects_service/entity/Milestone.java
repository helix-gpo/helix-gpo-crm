package com.helix.gpo.projects_service.entity;

import com.helix.gpo.projects_service.entity.status.MilestoneStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "MILESTONES")
public class Milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(nullable = false)
    private MilestoneStatus status;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "id")
    private Project project;

}
