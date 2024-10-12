package com.itec0401.backend.member.controller;

import com.itec0401.backend.member.dto.LoginResponseDTO;
import com.itec0401.backend.member.dto.LoginRequestDTO;
import com.itec0401.backend.member.dto.MemberDTO;
import com.itec0401.backend.member.repository.MemberRepository;
import com.itec0401.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    /**
     * @param loginRequestDTO
     * @return AccessToken 반환
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return memberService.login(loginRequestDTO);
    }

    @PostMapping("/new")
    public ResponseEntity<String> signIn(@RequestBody MemberDTO memberDTO){
        return memberService.signIn(memberDTO);
    }

    //아이디 체크
    @GetMapping("/email/{email}")
    public ResponseEntity<Boolean> checkEmail(@RequestParam String email){
        return memberService.checkEmail(email);
    }
}
