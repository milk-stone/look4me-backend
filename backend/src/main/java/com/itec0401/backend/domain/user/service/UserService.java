package com.itec0401.backend.domain.user.service;

import com.itec0401.backend.domain.user.dto.*;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<UserInfoDto> getUserProfile(String accessToken);
    ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequestDTO);
    ResponseEntity<String> signIn(MemberDTO memberDTO);
    ResponseEntity<Boolean> isEmailEmpty(String email);
    ResponseEntity<UserInfoDto> updateUserProfile(String accessToken, UpdateUserProfileDto updateUserProfileDto);
}