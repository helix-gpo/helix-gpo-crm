package com.helix.gpo.company_service.repository;

import com.helix.gpo.company_service.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
