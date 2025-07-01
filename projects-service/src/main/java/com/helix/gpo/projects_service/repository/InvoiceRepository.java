package com.helix.gpo.projects_service.repository;

import com.helix.gpo.projects_service.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
