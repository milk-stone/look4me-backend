package com.itec0401.backend.domain.clothing.dto;

import com.itec0401.backend.domain.clothing.entity.Clothing;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClothInfoDto {
    /* 용도 : 이미지를 Python 서버로 보냈을 때, 파이썬 서버가 보내준 정보를 담는 DTO */
    private String name;
    private String category;
    private String baseColor;
    private String pointColor;
    private String textile;
    private String pattern;
    private String season;
    private String style;
    private String description;

    public static ClothInfoDto toDto(Clothing clothing){
        return ClothInfoDto.builder()
                .name(clothing.getName())
                .category(clothing.getCategory().toString())
                .baseColor(clothing.getBaseColor().toString())
                .pointColor(clothing.getPointColor().toString())
                .textile(clothing.getTextile().toString())
                .pattern(clothing.getPattern().toString())
                .season(clothing.getSeason().toString())
                .style(clothing.getStyle().toString())
                .description(clothing.getDescription())
                .build();
    }
}
