package com.example.demo.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NutinfoUpdateRequestDto {
    private String foodName;
    private String calories;
    private String carbohydrate;
    private String protein;
    private String fat;

    @Builder
    public NutinfoUpdateRequestDto(String foodName, String calories,
                                   String carbohydrate, String protein, String fat) {
        this.foodName = foodName;
        this.calories = calories;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
    }
}
