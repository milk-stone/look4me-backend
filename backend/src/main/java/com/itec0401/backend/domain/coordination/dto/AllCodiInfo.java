package com.itec0401.backend.domain.coordination.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class AllCodiInfo {
    private final Long id;
    private final String name;
    private final String description;
    private final String hashtags;
    private final List<String> clothingImages;

    @Builder
    public AllCodiInfo(Long id, String name, String description, String hashtags, List<String> clothingImages) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hashtags = hashtags;
        this.clothingImages = clothingImages;
    }
}
