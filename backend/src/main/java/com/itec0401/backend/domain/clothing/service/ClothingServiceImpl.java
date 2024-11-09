package com.itec0401.backend.domain.clothing.service;

import com.itec0401.backend.domain.clothing.dto.ClothInfoDto;
import com.itec0401.backend.domain.clothing.entity.Clothing;
import com.itec0401.backend.domain.clothing.entity.type.Category;
import com.itec0401.backend.domain.clothing.entity.type.ColorType;
import com.itec0401.backend.domain.clothing.repository.ClothingRepository;
import com.itec0401.backend.domain.user.entity.User;
import com.itec0401.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClothingServiceImpl implements ClothingService {
    private final ClothingRepository clothingRepository;
    private final UserService userService;

    public ResponseEntity<ClothInfoDto> createClothing(ClothInfoDto clothInfoDto, Authentication authentication) {
        // 권한 확인
        System.out.println("hihihi");
        Optional<User> user = userService.checkPermission(authentication);
        if (user.isEmpty())
            return new ResponseEntity<>(ClothInfoDto.builder().build(), HttpStatus.BAD_REQUEST);

        System.out.println("2");
        Clothing c = Clothing.builder()
                .name(clothInfoDto.getName())
                .category(clothInfoDto.getCategory())
                .baseColor(clothInfoDto.getBaseColor())
                .pointColor(clothInfoDto.getPointColor())
                .textile(clothInfoDto.getTextile())
                .pattern(clothInfoDto.getPattern())
                .season(clothInfoDto.getSeason())
                .style(clothInfoDto.getStyle())
                .description(clothInfoDto.getDescription())
                .build();
        System.out.println("3");
        clothingRepository.save(c);
        System.out.println("4");
        return new ResponseEntity<>(ClothInfoDto.toDto(c), HttpStatus.CREATED);
    }
}
