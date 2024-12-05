package com.itec0401.backend.domain.usercolor.repository;

import com.itec0401.backend.domain.usercolor.entity.UserColor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserColorRepository extends JpaRepository<UserColor, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM user_color WHERE user_id = ?1", nativeQuery = true)
    void deleteByUserId(Long userId);
}
