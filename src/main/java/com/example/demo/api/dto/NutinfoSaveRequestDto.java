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
    private String allergic;
    private String standard;

    @Builder
    public NutinfoSaveRequestDto(String foodname, String calories, String carbohydrate,
                                 String protein, String fat, String allergic, String standard) {
        this.foodname = foodname;
        this.calories = calories;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
        this.allergic = allergic;
        this.standard = standard;
    }

    public Nutinfo toEntity() {
        return Nutinfo.builder()
                .foodname(foodname)
                .calories(calories)
                .carbohydrate(carbohydrate)
                .protein(protein)
                .fat(fat)
                .allergic(allergic)
                .standard(standard)
                .build();
    }
}
