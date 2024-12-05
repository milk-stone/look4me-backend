package com.itec0401.backend.domain.userstyle.entity;

import com.itec0401.backend.domain.style.entity.Style;
import com.itec0401.backend.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class UserStyle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userstyle_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "style_id")
    private Style style;

    public UserStyle(User user, Style style) {
        this.user = user;
        this.style = style;
    }
}
