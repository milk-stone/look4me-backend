package com.itec0401.backend.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserRequestDto {
    private final String name;
    private final String nickname;
    private final String email;

    private final int gender;
    private final int age;
    private final double height;
    private final double weight;
    private final String tone;

    private final String color;
    private final String style;
}
