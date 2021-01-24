package com.example.demo.service;

import com.example.demo.api.dto.NutinfoResponseDto;
import com.example.demo.api.dto.NutinfoSaveRequestDto;
import com.example.demo.api.dto.NutinfoUpdateRequestDto;
import com.example.demo.domain.Nutinfo;
import com.example.demo.domain.NutinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class NutinfoService {
    private final NutinfoRepository infoRepository;

    @Transactional
    public Long save(NutinfoSaveRequestDto requestDto) {
        return infoRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, NutinfoUpdateRequestDto requestDto) {
        Nutinfo nutinfo = infoRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("해당 정보가 존재하지 않습니다. id=" + id));
        nutinfo.update(requestDto.getFoodname(), requestDto.getCalories(), requestDto.getCarbohydrate(),
                        requestDto.getProtein(), requestDto.getFat());
        return id;
    }

    public NutinfoResponseDto findById(Long id) {
        Nutinfo entity = infoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 정보가 Table에 존재하지 않습니다. id=" + id));
        return new NutinfoResponseDto(entity);
    }

    public NutinfoResponseDto findByFoodname(String foodname) {
        Nutinfo entity = infoRepository.findByFoodname(foodname);
        return new NutinfoResponseDto(entity);
    }
}