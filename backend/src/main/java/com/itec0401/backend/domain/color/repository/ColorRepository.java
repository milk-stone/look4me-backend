package com.itec0401.backend.domain.color.repository;

import com.itec0401.backend.domain.color.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color, Long> {
    Optional<Color> findByColor(String color);
}
