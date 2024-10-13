package com.itec0401.backend.domain.user.controller;

import com.itec0401.backend.domain.user.dto.*;
import com.itec0401.backend.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(
            summary = "로그인",
            description = "Email, Password를 확인하고 AccessToken 발행함.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 로그인 되었습니다."),
                    @ApiResponse(responseCode = "404", description = "이메일이 틀렸습니다."),
                    @ApiResponse(responseCode = "401", description = "비밀번호가 틀렸습니다.")
            }
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return userService.login(loginRequestDTO);
    }

    @Operation(
            summary = "회원가입",
            description = "Body에 회원정보(임시) 담아서 요청보내면 회원가입을 시켜줌. 이메일 중복 확인 후 호출해야함.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 회원가입 되었습니다."),
                    @ApiResponse(responseCode = "400", description = "회원가입 실패. 이메일 중복되었을 가능성 있음")
            }
    )
    @PostMapping("/new")
    public ResponseEntity<String> signIn(@RequestBody MemberDTO memberDTO){
        return userService.signIn(memberDTO);
    }

    @Operation(
            summary = "이메일 중복 확인",
            description = "\"True: 회원가입 가능\" \"False: 회원가입 불가능\""
    )
    @GetMapping("/email/{email}")
    public ResponseEntity<Boolean> isEmailEmpty(@PathVariable String email){
        return userService.isEmailEmpty(email);
    }
}