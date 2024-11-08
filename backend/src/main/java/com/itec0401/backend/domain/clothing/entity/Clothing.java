package com.itec0401.backend.domain.clothing.entity;

import com.itec0401.backend.domain.clothing.entity.type.*;
import com.itec0401.backend.domain.coordinationclothing.entity.CoordinationClothing;
import com.itec0401.backend.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
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

    private String name;

    private Category category;

    @Enumerated(EnumType.STRING)
    private ColorType baseColor;

    @Enumerated(EnumType.STRING)
    private ColorType pointColor;

    @Enumerated(EnumType.STRING)
    private TextileType textile;

    @Enumerated(EnumType.STRING)
    private PatternType pattern;

    @Enumerated(EnumType.STRING)
    private SeasonType season;

    @Enumerated(EnumType.STRING)
    private StyleType style;

    private String description;

    @OneToMany(mappedBy = "clothing")
    private List<CoordinationClothing> coordinationClothingList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Clothing(String name,
                    String category,
                    String baseColor,
                    String pointColor,
                    String textile,
                    String pattern,
                    String season,
                    String style,
                    String description) {
        this.name = name;
        this.category = Category.convertString(category);
        this.baseColor = ColorType.convertString(baseColor);
        this.pointColor = ColorType.convertString(pointColor);
        this.textile = TextileType.convertString(textile);
        this.pattern = PatternType.convertString(pattern);
        this.season = SeasonType.convertString(season);
        this.style = StyleType.convertString(style);
        this.description = description;
    }

}
