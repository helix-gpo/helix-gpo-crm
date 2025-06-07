package com.helix.gpo.company_service.repository;

import com.helix.gpo.company_service.entity.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {

    Optional<AuthToken> findByValue(String value);

}
