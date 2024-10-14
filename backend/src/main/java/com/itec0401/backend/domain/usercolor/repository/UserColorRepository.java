package com.itec0401.backend.domain.usercolor.repository;

import com.itec0401.backend.domain.usercolor.entity.UserColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserColorRepository extends JpaRepository<UserColor, Long> {
    void deleteByUserId(Long userId);
}
