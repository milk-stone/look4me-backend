package com.itec0401.backend.domain.usercolor.service;

import com.itec0401.backend.domain.color.entity.Color;
import com.itec0401.backend.domain.color.service.ColorService;
import com.itec0401.backend.domain.user.entity.User;
import com.itec0401.backend.domain.usercolor.entity.UserColor;
import com.itec0401.backend.domain.usercolor.repository.UserColorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserColorServiceImpl implements UserColorService {
    private final UserColorRepository userColorRepository;
    private final ColorService colorService;

    @Transactional
    public void createUserColor(User user, Color color) {
        userColorRepository.save(new UserColor(user, color));
    }
}
