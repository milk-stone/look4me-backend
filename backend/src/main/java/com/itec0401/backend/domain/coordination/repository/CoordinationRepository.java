package com.itec0401.backend.domain.coordination.repository;

import com.itec0401.backend.domain.coordination.entity.Coordination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinationRepository extends JpaRepository<Coordination, Long> {
}
