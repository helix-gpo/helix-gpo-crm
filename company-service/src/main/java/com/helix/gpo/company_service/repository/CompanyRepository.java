package com.helix.gpo.company_service.repository;

import com.helix.gpo.company_service.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
