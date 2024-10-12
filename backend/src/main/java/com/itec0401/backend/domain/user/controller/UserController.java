package com.itec0401.backend.domain.user.controller;

import com.itec0401.backend.domain.user.dto.*;
import com.itec0401.backend.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Operation(summary = "마이 페이지 열람")
    @GetMapping("/profile")
    public ResponseEntity<UserInfoDto> getUserProfile(@RequestParam Long user_id) {
        return ResponseEntity.ok(userService.getUserProfile(user_id));
    }

    @Operation(summary = "마이 페이지 수정")
    @PutMapping("/profile")
    public ResponseEntity<UserInfoDto> updateUserProfile(@RequestParam Long user_id, @RequestBody UpdateUserProfileDto updateUserProfileDto) {
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return userService.login(loginRequestDTO);
    }

    @PostMapping("/new")
    public ResponseEntity<String> signIn(@RequestBody MemberDTO memberDTO){
        return userService.signIn(memberDTO);
    }

    //아이디 체크
    @GetMapping("/email/{email}")
    public ResponseEntity<Boolean> isEmailEmpty(@PathVariable String email){
        return userService.isEmailEmpty(email);
    }
}