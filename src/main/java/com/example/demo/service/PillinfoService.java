package com.example.demo.service;

import com.example.demo.api.dto.PillinfoResponseDto;
import com.example.demo.api.dto.PillinfoSaveRequestDto;
import com.example.demo.api.dto.PillinfoUpdateRequestDto;
import com.example.demo.domain.Pillinfo;
import com.example.demo.domain.PillinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PillinfoService {
    private final PillinfoRepository pillinfoRepository;

    @Transactional
    public Long save(PillinfoSaveRequestDto requestDto) { return pillinfoRepository.save(requestDto.toEntity()).getId(); }

    @Transactional
    public Long update(Long id, PillinfoUpdateRequestDto requestDto) {
        Pillinfo pillinfo = pillinfoRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("해당 정보가 테이블에 존재하지 않습니다. id=" + id));
        pillinfo.update(requestDto.getPillname(), requestDto.getEffect(), requestDto.getCompany(),
                        requestDto.getEngrave(), requestDto.getSideeffect(), requestDto.getUrl());
        return id;
    }

    public PillinfoResponseDto findById(Long id) {
        Pillinfo entity = pillinfoRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("해당 id가 테이블에 존재하지 않습니다 : " + id));
        return new PillinfoResponseDto(entity);
    }

    public PillinfoResponseDto findByPillname(String pillname) {
        Pillinfo entity = pillinfoRepository.findByPillname(pillname);
        return new PillinfoResponseDto(entity);
    }
}
