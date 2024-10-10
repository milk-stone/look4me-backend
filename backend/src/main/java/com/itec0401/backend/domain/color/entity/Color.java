package com.itec0401.backend.domain.color.entity;

import com.itec0401.backend.domain.usercolor.entity.UserColor;
import com.itec0401.backend.global.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Color extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private Long id;

    private String style;

    @OneToMany(mappedBy = "color")
    private List<UserColor> userColors;
}
