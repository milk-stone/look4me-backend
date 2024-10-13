package com.itec0401.backend.domain.usercolor.service;

import com.itec0401.backend.domain.color.entity.Color;
import com.itec0401.backend.domain.user.entity.User;

public interface UserColorService {
    void createUserColor(User user, Color color);
}
