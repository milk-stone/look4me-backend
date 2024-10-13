package com.itec0401.backend.domain.usercolor.entity;

import com.itec0401.backend.domain.color.entity.Color;
import com.itec0401.backend.domain.user.entity.User;
import com.itec0401.backend.global.BaseEntityWithUpdatedAt;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class UserColor extends BaseEntityWithUpdatedAt {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usercolor_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    public UserColor(User user, Color color) {
        this.user = user;
        this.color = color;
    }
}
