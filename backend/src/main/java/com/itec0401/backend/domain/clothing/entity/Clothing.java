package com.itec0401.backend.domain.clothing.entity;

import com.itec0401.backend.domain.clothing.entity.type.weatherType;
import com.itec0401.backend.domain.coordinationclothing.entity.CoordinationClothing;
import com.itec0401.backend.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Clothing {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clothing_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private weatherType weather;

    // 다른 특징들을 enum 화 할건지 테이블 만들어서 쓸 건지 결정 해야함!
    private String category;

    private String subCategory;

    private String textile;

    private String pattern;

    private String baseColor;

    private String pointColor;

    @OneToMany(mappedBy = "clothing")
    private List<CoordinationClothing> coordinationClothingList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
