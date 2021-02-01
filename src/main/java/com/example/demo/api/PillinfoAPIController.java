package com.example.demo.api;

import com.example.demo.api.dto.PillinfoResponseDto;
import com.example.demo.api.dto.PillinfoSaveRequestDto;
import com.example.demo.service.PillinfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PillinfoAPIController {
    @Autowired
    private final PillinfoService pillinfoService;

    @PostMapping("/search/pill")
    public Long save(@RequestBody PillinfoSaveRequestDto requestDto) { return pillinfoService.save(requestDto); }

    @GetMapping("/search/pill/{id}")
    public PillinfoResponseDto findById (@PathVariable Long id) {
        return pillinfoService.findById(id);
    }

    @GetMapping("search/pill/name/{pillname}")
    public PillinfoResponseDto findByPillname (@PathVariable String pillname) {
        return pillinfoService.findByPillname(pillname);
    }
}
