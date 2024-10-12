package com.itec0401.backend.domain.user.controller;

import com.itec0401.backend.domain.user.dto.UpdateUserProfileDto;
import com.itec0401.backend.domain.user.dto.UserInfoDto;
import com.itec0401.backend.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "마이 페이지 열람")
    @GetMapping("user/profile")
    public ResponseEntity<UserInfoDto> getUserProfile(@RequestParam Long user_id) {
        return ResponseEntity.ok(userService.getUserProfile(user_id));
    }

    @Operation(summary = "마이 페이지 수정")
    @PutMapping("user/profile")
    public ResponseEntity<UserInfoDto> updateUserProfile(@RequestParam Long user_id, @RequestBody UpdateUserProfileDto updateUserProfileDto) {

    }
}
