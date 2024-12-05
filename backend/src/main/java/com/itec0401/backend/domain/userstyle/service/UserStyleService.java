package com.itec0401.backend.domain.userstyle.service;

import com.itec0401.backend.domain.style.entity.Style;
import com.itec0401.backend.domain.user.entity.User;

public interface UserStyleService {
    void createUserStyle(User user, Style style);
    void deleteAllUserStyles(User user);
}
