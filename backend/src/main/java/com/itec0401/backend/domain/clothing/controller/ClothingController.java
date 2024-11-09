package com.itec0401.backend.domain.clothing.controller;


import com.itec0401.backend.domain.clothing.dto.ClothInfoDto;
import com.itec0401.backend.domain.clothing.service.ClothingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mycloth")
public class ClothingController {
    private final ClothingService clothingService;

    // for test
    @PostMapping("/test")
    public ResponseEntity<ClothInfoDto> createClothing(@RequestBody ClothInfoDto clothInfoDto, Authentication authentication){
        return clothingService.createClothing(clothInfoDto, authentication);
    }

    /*
    @PostMapping("/upload")
    public ResponseEntity<ClothInfoDto> uploadClothingImage(Authentication authentication, @RequestParam("file") MultipartFile file){
        return clothingService;
    }
    */

}
