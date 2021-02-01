package com.example.demo.api.dto;

import com.example.demo.domain.Pillinfo;
import lombok.Getter;

@Getter
public class PillinfoResponseDto {
    private Long id;
    private String pillname;
    private String effect;
    private String company;
    private String engrave;
    private String sideeffect;
    private String url;

    public PillinfoResponseDto(Pillinfo entity) {
        this.id = entity.getId();
        this.pillname = entity.getPillname();
        this.effect = entity.getEffect();
        this.company = entity.getCompany();
        this.engrave = entity.getEngrave();
        this.sideeffect = entity.getSideeffect();
        this.url = entity.getUrl();
    }
}
