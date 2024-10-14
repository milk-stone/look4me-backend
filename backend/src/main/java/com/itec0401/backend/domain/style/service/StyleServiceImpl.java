package com.itec0401.backend.domain.style.service;

import com.itec0401.backend.domain.style.entity.Style;
import com.itec0401.backend.domain.style.repository.StyleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StyleServiceImpl implements StyleService {
    private final StyleRepository styleRepository;

    // Style 이름으로 style 객체 찾기
    @Override
    public Optional<Style> findStyleByName(String style) {
        return styleRepository.findByStyle(style);
    }

    // Style 초기 값 생성은 관리자가 DB에 직접 넣기!
}
