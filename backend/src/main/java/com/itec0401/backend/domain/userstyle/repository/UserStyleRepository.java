package com.itec0401.backend.domain.userstyle.repository;

import com.itec0401.backend.domain.userstyle.entity.UserStyle;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserStyleRepository extends JpaRepository<UserStyle, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM user_style WHERE user_id = ?1", nativeQuery = true)
    void deleteByUserId(Long userId);
}
