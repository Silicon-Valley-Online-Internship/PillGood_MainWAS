package com.example.demo.api.dto;

import com.example.demo.domain.Pillinfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PillinfoSaveRequestDto {
    private String pillname;
    private String effect;
    private String company;
    private String engrave;
    private String sideeffect;
    private String url;

    @Builder
    public PillinfoSaveRequestDto(String pillname, String effect, String company,
                                  String engrave, String sideeffect, String url) {
        this.pillname = pillname;
        this.effect = effect;
        this.company = company;
        this.engrave = engrave;
        this.sideeffect = sideeffect;
        this.url = url;
    }

    public Pillinfo toEntity() {
        return Pillinfo.builder()
                .pillname(pillname)
                .effect(effect)
                .company(company)
                .engrave(engrave)
                .sideeffect(sideeffect)
                .url(url)
                .build();
    }
}
