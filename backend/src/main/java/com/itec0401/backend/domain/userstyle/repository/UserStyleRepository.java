package com.itec0401.backend.domain.userstyle.repository;

import com.itec0401.backend.domain.userstyle.entity.UserStyle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStyleRepository extends JpaRepository<UserStyle, Long> {
    void deleteByUserId(Long userId);
}
