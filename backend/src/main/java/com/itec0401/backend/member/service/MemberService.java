package com.itec0401.backend.member.service;

import com.itec0401.backend.member.dto.LoginRequestDTO;
import com.itec0401.backend.member.dto.LoginResponseDTO;
import com.itec0401.backend.member.dto.MemberDTO;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequestDTO);

    ResponseEntity<String> signIn(MemberDTO memberDTO);

    ResponseEntity<Boolean> checkEmail(String email);
}
