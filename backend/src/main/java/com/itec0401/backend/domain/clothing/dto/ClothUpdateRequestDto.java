package com.itec0401.backend.domain.clothing.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClothUpdateRequestDto {
    private String imageUri;
    private String name;
    private String mainCategory;
    private String subCategory;
    private String baseColor;
    private String pointColor;
    private String textile;
    private String pattern;
    private String season;
    private String style;
    private String description;
}
