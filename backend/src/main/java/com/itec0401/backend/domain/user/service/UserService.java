package com.itec0401.backend.domain.user.service;

import com.itec0401.backend.domain.user.dto.UserInfoDto;
import com.itec0401.backend.domain.user.entity.User;
import com.itec0401.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserInfoDto getUserProfile(Long id){
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            return null;
        }
        else {
            return UserInfoDto.toDto(user);
        }
    }

}
