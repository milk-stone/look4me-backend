package com.itec0401.backend.domain.user.dto;

import com.itec0401.backend.domain.color.entity.Color;
import com.itec0401.backend.domain.style.entity.Style;
import com.itec0401.backend.domain.user.entity.User;
import com.itec0401.backend.domain.usercolor.entity.UserColor;
import com.itec0401.backend.domain.userstyle.entity.UserStyle;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class UserInfoDto {
    private final String email;
    private final String nickName;

    private final int gender;
    private final int age;
    private final double height;
    private final double weight;
    private final String tone;

    private final List<String> colorList;
    private final List<String> styleList;

    public static UserInfoDto toDto(User user){
        List<String> userColors = user.getUserColorList().stream()
                .map(userColor -> userColor.getColor().getColor())
                .toList();
        List<String> userStyles = user.getUserStyleList().stream()
                .map(userStyle -> userStyle.getStyle().getStyle())
                .toList();
        return UserInfoDto.builder()
                .email(user.getEmail())
                .nickName(user.getNickname())
                .gender(user.getGender())
                .age(user.getAge())
                .height(user.getHeight())
                .weight(user.getWeight())
                .tone(user.getTone())
                .colorList(userColors)
                .styleList(userStyles)
                .build();
    }
}
