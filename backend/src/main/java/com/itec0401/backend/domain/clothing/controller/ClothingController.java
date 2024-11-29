package com.itec0401.backend.domain.clothing.controller;


import com.itec0401.backend.domain.clothing.dto.ClothInfoDto;
import com.itec0401.backend.domain.clothing.dto.ClothUpdateRequestDto;
import com.itec0401.backend.domain.clothing.service.ClothingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mycloth")
public class ClothingController {
    private final ClothingService clothingService;

    @Operation(
            summary = "옷 등록",
            description = "Authentication으로 유저 판별 유저의 옷 등록",
            responses = {
                    @ApiResponse(responseCode = "200", description = "옷 등록 성공"),
                    @ApiResponse(responseCode = "401", description = "옷 등록 실패, 토큰 만료 여부 판단 바람")
            }
    )
    @PostMapping("/upload")
    public ResponseEntity<ClothInfoDto> createClothing(@RequestBody ClothInfoDto clothInfoDto, Authentication authentication){
        return clothingService.createClothing(clothInfoDto, authentication);
    }

    @Operation(
            summary = "특정 옷 조회",
            description = "PathVariable 로 id 값을 받고, 그 id를 가진 옷 정보 반환"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ClothInfoDto> getClothingById(@PathVariable Long id, Authentication authentication){
        return clothingService.getClothingById(id, authentication);
    }

    @Operation(
            summary = "특정 옷 수정",
            description = "PathVariable로 id 값을 받고, RequestBody로 업데이트 내용을 받으면 그 옷을 찾아서 내용 수정"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClothing(@PathVariable Long id, @RequestBody ClothUpdateRequestDto dto, Authentication authentication){
        return clothingService.updateClothing(id, dto, authentication);
    }

    @Operation(
            summary = "유저의 모든 옷 열람",
            description = "ClothInfoDto 내용 대로 모든 옷 정보 반환"
    )
    @GetMapping()
    public ResponseEntity<List<ClothInfoDto>> getAllClothings(Authentication authentication){
        return clothingService.getAllClothings(authentication);
    }

    /*
    @PostMapping("/upload")
    public ResponseEntity<ClothInfoDto> uploadClothingImage(Authentication authentication, @RequestParam("file") MultipartFile file){
        return clothingService;
    }
    */

}
