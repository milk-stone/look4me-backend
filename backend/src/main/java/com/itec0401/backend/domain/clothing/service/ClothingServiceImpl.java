package com.itec0401.backend.domain.clothing.service;

import com.itec0401.backend.domain.clothing.dto.ClothInfoDto;
import com.itec0401.backend.domain.clothing.dto.ClothUpdateRequestDto;
import com.itec0401.backend.domain.clothing.entity.Clothing;
import com.itec0401.backend.domain.clothing.entity.type.Category;
import com.itec0401.backend.domain.clothing.entity.type.ColorType;
import com.itec0401.backend.domain.clothing.repository.ClothingRepository;
import com.itec0401.backend.domain.user.entity.User;
import com.itec0401.backend.domain.user.service.UserService;
import com.itec0401.backend.global.exception.ClothingNotFoundException;
import com.itec0401.backend.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClothingServiceImpl implements ClothingService {
    private final ClothingRepository clothingRepository;
    private final UserService userService;

    public ResponseEntity<ClothInfoDto> createClothing(ClothInfoDto clothInfoDto, Authentication authentication) {
        // 권한 확인
        Optional<User> user = userService.checkPermission(authentication);
        if (user.isEmpty())
            return new ResponseEntity<>(ClothInfoDto.builder().build(), HttpStatus.BAD_REQUEST);
        User validUser = user.get();
        Clothing c = Clothing.builder()
                .imageUri(clothInfoDto.getImageUri())
                .name(clothInfoDto.getName())
                .mainCategory(clothInfoDto.getMainCategory())
                .subCategory(clothInfoDto.getSubCategory())
                .baseColor(clothInfoDto.getBaseColor())
                .pointColor(clothInfoDto.getPointColor())
                .textile(clothInfoDto.getTextile())
                .pattern(clothInfoDto.getPattern())
                .season(clothInfoDto.getSeason())
                .style(clothInfoDto.getStyle())
                .description(clothInfoDto.getDescription())
                .user(validUser)
                .build();

        clothingRepository.save(c);

        return new ResponseEntity<>(ClothInfoDto.toDto(c), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ClothInfoDto> getClothingById(Long id, Authentication authentication) {
        Optional<User> user = userService.checkPermission(authentication);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        User validUser = user.get();

        Optional<Clothing> clothing = clothingRepository.findByClothingId(id);
        if (clothing.isEmpty()) {
            throw new ClothingNotFoundException("Clothing not found");
        }
        Clothing c = clothing.get();
        return  new ResponseEntity<>(ClothInfoDto.toDto(c), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateClothing(Long id, ClothUpdateRequestDto dto, Authentication authentication) {
        Optional<User> user = userService.checkPermission(authentication);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        User validUser = user.get();

        Optional<Clothing> clothing = clothingRepository.findByClothingId(id);
        if (clothing.isEmpty()) {
            throw new ClothingNotFoundException("Clothing not found");
        }
        Clothing c = clothing.get();
        c.update(dto);
        clothingRepository.save(c);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ClothInfoDto>> getAllClothings(Authentication authentication) {
        Optional<User> user = userService.checkPermission(authentication);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        User validUser = user.get();

        List<ClothInfoDto> clothInfoDtos = new ArrayList<>();
        for (Clothing c : validUser.getClothingList()){
            clothInfoDtos.add(ClothInfoDto.toDto(c));
        }
        return new ResponseEntity<>(clothInfoDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> deleteClothingById(Long id, Authentication authentication) {
        Optional<User> user = userService.checkPermission(authentication);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        User validUser = user.get();

        return new ResponseEntity<>(clothingRepository.deleteByTwoId(validUser.getId(), id), HttpStatus.OK);
    }
}
