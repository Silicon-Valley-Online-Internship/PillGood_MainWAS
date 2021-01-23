package com.example.demo.api.dto;

import com.example.demo.domain.Nutinfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NutinfoSaveRequestDto {
    private String foodName;
    private String calories;
    private String carbohydrate;
    private String protein;
    private String fat;

    @Builder
    public NutinfoSaveRequestDto(String foodName, String calories, String carbohydrate,
                                 String protein, String fat) {
        this.foodName = foodName;
        this.calories = calories;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
    }

    public Nutinfo toEntity() {
        return Nutinfo.builder()
                .foodName(foodName)
                .calories(calories)
                .carbohydrate(carbohydrate)
                .protein(protein)
                .fat(fat)
                .build();
    }
}
