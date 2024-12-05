package com.itec0401.backend.domain.style.entity;

import com.itec0401.backend.domain.userstyle.entity.UserStyle;
import com.itec0401.backend.global.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Style extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "style_id")
    private Long id;

    private String style;

    @OneToMany(mappedBy = "style")
    private List<UserStyle> userStyles;

    @Builder
    public Style(String style){
        this.style = style;
    }
}
