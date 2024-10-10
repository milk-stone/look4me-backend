package com.itec0401.backend.domain.user.entity;

import com.itec0401.backend.domain.coordination.entity.Coordination;
import com.itec0401.backend.domain.usercolor.entity.UserColor;
import com.itec0401.backend.domain.userstyle.entity.UserStyle;
import com.itec0401.backend.global.BaseEntityWithUpdatedAt;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseEntityWithUpdatedAt {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    // google login API 보고 email, password 필드 생각 다시 해야함
    // google 로그인 하면 이메일, 닉네임 받아올 수 있으려나?

    // 유저 추가 정보
    private int gender;
    private int age;
    private double height;
    private double weight;
    private String tone;

    // mapping

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Coordination> coordinationList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserStyle> userStyleList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserColor> userColorList;
}
