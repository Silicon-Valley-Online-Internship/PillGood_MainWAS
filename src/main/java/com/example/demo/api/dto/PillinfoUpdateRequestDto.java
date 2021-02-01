package com.example.demo.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PillinfoUpdateRequestDto {
    private String pillname;
    private String effect;
    private String company;
    private String engrave;
    private String sideeffect;
    private String url;

    @Builder
    public PillinfoUpdateRequestDto(String pillname, String effect, String company,
                                  String engrave, String sideeffect, String url) {
        this.pillname = pillname;
        this.effect = effect;
        this.company = company;
        this.engrave = engrave;
        this.sideeffect = sideeffect;
        this.url = url;
    }
}
