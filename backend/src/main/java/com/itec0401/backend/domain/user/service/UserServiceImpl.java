package com.itec0401.backend.domain.user.service;

import com.itec0401.backend.domain.user.dto.LoginRequestDTO;
import com.itec0401.backend.domain.user.dto.LoginResponseDTO;
import com.itec0401.backend.domain.user.dto.MemberDTO;
import com.itec0401.backend.domain.user.dto.UserInfoDto;
import com.itec0401.backend.domain.user.entity.User;
import com.itec0401.backend.domain.user.jwt.JwtTokenProvider;
import com.itec0401.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public UserInfoDto getUserProfile(Long id){
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            return null;
        }
        else {
            return UserInfoDto.toDto(user);
        }
    }

    @Override
    public ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequestDTO) {
        //AccessToken 만들어서 줘야함
        Optional<User> byEmail = userRepository.findByEmail(loginRequestDTO.getEmail());
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
            User saved = userRepository.save(User.builder()
                    .name(memberDTO.getName())
                    .email(memberDTO.getEmail())
                    .nickname(memberDTO.getNickName())
                    .password(encoded)
                    .build());

            // 저장된 객체가 null인 경우 처리
            return new ResponseEntity<>("회원가입 완료", HttpStatus.OK); // 성공 시 200 반환
        } catch (Exception e) {
            // 예외 발생 시 처리
            System.out.println("e = " + e);
            return new ResponseEntity<>("회원가입 실패", HttpStatus.BAD_REQUEST); // 이메일 조회 후 회원가입 할것
        }
    }

    @Override
    public ResponseEntity<Boolean> isEmailEmpty(String email) {
        return new ResponseEntity<>(userRepository.findByEmail(email).isEmpty(), HttpStatus.OK);
    }
}
