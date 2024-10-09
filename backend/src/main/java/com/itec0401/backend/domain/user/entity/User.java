package com.itec0401.backend.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    private String nickname;

    // google login API 보고 email, password 필드 생각 다시 해야함

    // 유저 추가 정보
    private int gender;
    private int age;
    private double height;
    private double weight;
    private String tone;

    // mapping

}
