package com.itec0401.backend.domain.user.service;

import com.itec0401.backend.domain.user.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface UserService {
    ResponseEntity<UserInfoDto> getUserProfile(Authentication authentication);
    ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequestDTO);
    ResponseEntity<String> signIn(MemberDTO memberDTO);
    ResponseEntity<Boolean> isEmailEmpty(String email);
    ResponseEntity<UserInfoDto> updateUserProfile(UpdateUserProfileDto updateUserProfileDto, Authentication authentication);
}