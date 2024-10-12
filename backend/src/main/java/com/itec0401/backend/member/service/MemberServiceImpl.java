package com.itec0401.backend.member.service;

import com.itec0401.backend.member.dto.LoginRequestDTO;
import com.itec0401.backend.member.dto.LoginResponseDTO;
import com.itec0401.backend.member.dto.MemberDTO;
import com.itec0401.backend.member.entity.MemberEntity;
import com.itec0401.backend.member.jwt.JwtTokenProvider;
import com.itec0401.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService{

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequestDTO) {
        //AccessToken 만들어서 줘야함
        Optional<MemberEntity> byEmail = memberRepository.findByEmail(loginRequestDTO.getEmail());
        if (byEmail.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (!passwordEncoder.matches(loginRequestDTO.getPassword(), byEmail.get().getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            LoginResponseDTO loginResponseDTO = LoginResponseDTO.builder().
                    accessToken(jwtTokenProvider.createAccessToken(loginRequestDTO.getEmail()))
                    .build();
            return new ResponseEntity<>(loginResponseDTO, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<String> signIn(MemberDTO memberDTO) {
        try {
            // 비밀번호 인코딩
            String encoded = passwordEncoder.encode(memberDTO.getPassword());

            // 회원 저장
            MemberEntity saved = memberRepository.save(MemberEntity.builder()
                    .email(memberDTO.getEmail())
                    .username(memberDTO.getUsername())
                    .password(encoded)
                    .build());

            // 저장된 객체가 null인 경우 처리
            return new ResponseEntity<>("회원가입 완료", HttpStatus.OK); // 성공 시 200 반환
        } catch (Exception e) {
            // 예외 발생 시 처리
            return new ResponseEntity<>("회원가입 실패", HttpStatus.BAD_REQUEST); // 이메일 조회 후 회원가입 할것
        }
    }

    @Override
    public ResponseEntity<Boolean> checkEmail(String email) {
        return new ResponseEntity<>(memberRepository.findByEmail(email).isPresent(), HttpStatus.OK);
    }
}
