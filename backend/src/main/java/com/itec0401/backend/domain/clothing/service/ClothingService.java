package com.itec0401.backend.domain.clothing.service;


import com.itec0401.backend.domain.clothing.dto.ClothInfoDto;
import com.itec0401.backend.domain.clothing.dto.ClothUpdateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ClothingService {
    ResponseEntity<ClothInfoDto> createClothing(ClothInfoDto clothInfoDto, Authentication authentication);
    ResponseEntity<ClothInfoDto> getClothingById(Long id, Authentication authentication);
    ResponseEntity<Void> updateClothing(Long id, ClothUpdateRequestDto dto, Authentication authentication);
    ResponseEntity<List<ClothInfoDto>> getAllClothings(Authentication authentication);
    ResponseEntity<Integer> deleteClothingById(Long id, Authentication authentication);
}
