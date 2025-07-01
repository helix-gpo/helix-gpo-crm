package com.helix.gpo.projects_service.entity;

import com.helix.gpo.projects_service.entity.status.InvoiceStatus;
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
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String invoiceNumber;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate issueDate;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private BigDecimal totalNetAmount;

    @Column(nullable = false)
    private BigDecimal totalTaxAmount;

    @Column(nullable = false)
    private BigDecimal totalGrossAmount;

    @Column(nullable = false)
    private String reasonForPayment;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "milestone_id", referencedColumnName = "id")
    private Milestone milestone;

}
