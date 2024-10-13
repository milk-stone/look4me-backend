package com.itec0401.backend.domain.color.service;

import com.itec0401.backend.domain.color.entity.Color;
import com.itec0401.backend.domain.color.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {
    private final ColorRepository colorRepository;

    // Color 이름으로 color 객체 찾기
    public Optional<Color> findColorByName(String color) {
        return colorRepository.findByColor(color);
    }

    // Color 초기 값 생성은 관리자가 DB에 직접 넣기!
}
