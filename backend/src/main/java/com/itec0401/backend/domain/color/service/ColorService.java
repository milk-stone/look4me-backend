package com.itec0401.backend.domain.color.service;

import com.itec0401.backend.domain.color.entity.Color;
import com.itec0401.backend.domain.color.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ColorService {
    Optional<Color> findColorByName(String color);
}
