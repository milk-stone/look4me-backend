package com.itec0401.backend.domain.style.repository;

import com.itec0401.backend.domain.style.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StyleRepository extends JpaRepository<Style, Long> {
    Optional<Style> findByStyle(String style);
}
