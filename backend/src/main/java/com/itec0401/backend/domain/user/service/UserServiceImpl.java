package com.itec0401.backend.domain.user.service;

import com.itec0401.backend.domain.color.entity.Color;
import com.itec0401.backend.domain.color.service.ColorService;
import com.itec0401.backend.domain.style.entity.Style;
import com.itec0401.backend.domain.style.service.StyleService;
import com.itec0401.backend.domain.user.dto.*;
import com.itec0401.backend.domain.user.entity.User;
import com.itec0401.backend.domain.user.jwt.JwtTokenProvider;
import com.itec0401.backend.domain.user.repository.UserRepository;
import com.itec0401.backend.domain.usercolor.service.UserColorService;
import com.itec0401.backend.domain.userstyle.service.UserStyleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserColorService userColorService;
    private final UserStyleService userStyleService;
    private final StyleService styleService;
    private final ColorService colorService;

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
            log.info("회원가입 중 오류: " + e);
            return new ResponseEntity<>("회원가입 실패", HttpStatus.BAD_REQUEST); // 이메일 조회 후 회원가입 할것
        }
    }

    @Override
    public ResponseEntity<Boolean> isEmailEmpty(String email) {
        return new ResponseEntity<>(userRepository.findByEmail(email).isEmpty(), HttpStatus.OK);
    }

    @Override
    @Transactional
    public UserInfoDto updateUserProfile(String accessToken, UpdateUserProfileDto updateUserProfileDto){
        // accessToken 으로 user를 잘 구해오는지 확인해야함. 코드 수정 요망
        User user = userRepository.findById(Long.parseLong(accessToken)).get();

        userColorService.deleteAllUserColors(user);
        userStyleService.deleteAllUserStyles(user);

        for (String color : updateUserProfileDto.getColorList()){
            Optional<Color> cur = colorService.findColorByName(color);
            cur.ifPresent(value -> userColorService.createUserColor(user, value));
        }
        for (String style : updateUserProfileDto.getStyleList()) {
            Optional<Style> cur = styleService.findStyleByName(style);
            cur.ifPresent(value -> userStyleService.createUserStyle(user, value));
        }
        user.update(updateUserProfileDto);
        userRepository.save(user);
        return UserInfoDto.toDto(user);
    }
}
