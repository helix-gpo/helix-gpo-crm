package com.helix.gpo.company_service.repository;

import com.helix.gpo.company_service.entity.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {
}
