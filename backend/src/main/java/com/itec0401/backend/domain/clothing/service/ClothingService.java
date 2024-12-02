package com.itec0401.backend.domain.clothing.service;


import com.itec0401.backend.domain.clothing.dto.ClothInfoDto;
import com.itec0401.backend.domain.clothing.dto.ClothRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ClothingService {
    ResponseEntity<Void> createClothing(ClothRequestDto dto, Authentication authentication);
    ResponseEntity<ClothInfoDto> getClothingById(Long id, Authentication authentication);
    ResponseEntity<Void> updateClothing(Long id, ClothRequestDto dto, Authentication authentication);
    ResponseEntity<List<ClothInfoDto>> getAllClothings(Authentication authentication);
    ResponseEntity<Integer> deleteClothingById(Long id, Authentication authentication);
}
