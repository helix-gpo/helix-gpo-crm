package com.helix.gpo.company_service.repository;

import com.helix.gpo.company_service.entity.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {
}
