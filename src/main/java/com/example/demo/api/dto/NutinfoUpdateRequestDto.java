package com.example.demo.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NutinfoUpdateRequestDto {
    private String foodname;
    private String calories;
    private String carbohydrate;
    private String protein;
    private String fat;
    private String allergic;
    private String standard;

    @Builder
    public NutinfoUpdateRequestDto(String foodname, String calories,
                                   String carbohydrate, String protein, String fat, String allergic, String standard) {
        this.foodname = foodname;
        this.calories = calories;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
        this.allergic = allergic;
        this.standard = standard;
    }
}
