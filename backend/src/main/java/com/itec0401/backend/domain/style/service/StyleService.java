package com.itec0401.backend.domain.style.service;

import com.itec0401.backend.domain.style.entity.Style;
import java.util.Optional;


public interface StyleService {
    Optional<Style> findStyleByName(String style);
}
