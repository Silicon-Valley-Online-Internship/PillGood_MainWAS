package com.example.demo.api.dto;

import com.example.demo.domain.Nutinfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NutinfoSaveRequestDto {
    private String foodname;
    private String calories;
    private String carbohydrate;
    private String protein;
    private String fat;

    @Builder
    public NutinfoSaveRequestDto(String foodname, String calories, String carbohydrate,
                                 String protein, String fat) {
        this.foodname = foodname;
        this.calories = calories;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
    }

    public Nutinfo toEntity() {
        return Nutinfo.builder()
                .foodname(foodname)
                .calories(calories)
                .carbohydrate(carbohydrate)
                .protein(protein)
                .fat(fat)
                .build();
    }
}
