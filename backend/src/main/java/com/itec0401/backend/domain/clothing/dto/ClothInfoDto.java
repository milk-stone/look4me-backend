package com.itec0401.backend.domain.clothing.dto;

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
}
