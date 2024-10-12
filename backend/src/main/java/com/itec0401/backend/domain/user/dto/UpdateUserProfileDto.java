package com.itec0401.backend.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class UpdateUserProfileDto {
    private final String nickname;

    private final int gender;
    private final int age;
    private final double height;
    private final double weight;
    private final String tone;

    private final List<String> colorList;
    private final List<String> styleList;
}
