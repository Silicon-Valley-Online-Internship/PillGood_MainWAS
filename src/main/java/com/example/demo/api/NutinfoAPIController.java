package com.example.demo.api;

import com.example.demo.api.dto.NutinfoResponseDto;
import com.example.demo.api.dto.NutinfoSaveRequestDto;
import com.example.demo.api.dto.NutinfoUpdateRequestDto;
import com.example.demo.domain.NutinfoRepository;
import com.example.demo.service.NutinfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class NutinfoAPIController {

    @Autowired
    private final NutinfoService nutinfoService;

    @PostMapping("/search/nut")
    public Long save(@RequestBody NutinfoSaveRequestDto requestDto) {
        return nutinfoService.save(requestDto);
    }
    /*
    @PutMapping("/api/v1/nut/{id}")
    public Long update(@PathVariable Long id, @RequestBody NutinfoUpdateRequestDto requestDto) {
        return nutinfoService.update(id, requestDto);
    }
    */

    @GetMapping("/search/nut/{id}")
    public NutinfoResponseDto findById (@PathVariable Long id) {
        return nutinfoService.findById(id);
    }

    @GetMapping("/search/nut/name/{foodname}")
    public NutinfoResponseDto findByFoodname (@PathVariable String foodname) {
        return nutinfoService.findByFoodname(foodname);
    }
}