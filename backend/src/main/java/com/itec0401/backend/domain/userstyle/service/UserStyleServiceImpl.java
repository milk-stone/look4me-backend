package com.itec0401.backend.domain.userstyle.service;

import com.itec0401.backend.domain.style.entity.Style;
import com.itec0401.backend.domain.style.service.StyleService;
import com.itec0401.backend.domain.user.entity.User;
import com.itec0401.backend.domain.userstyle.entity.UserStyle;
import com.itec0401.backend.domain.userstyle.repository.UserStyleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserStyleServiceImpl implements UserStyleService {
    private final UserStyleRepository userStyleRepository;
    private final StyleService styleService;

    @Transactional
    public void createUserStyle(User user, Style style) {
        userStyleRepository.save(new UserStyle(user, style));

    }

}
