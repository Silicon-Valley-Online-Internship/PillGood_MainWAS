package com.example.demo.api.dto;

import com.example.demo.domain.Nutinfo;
import lombok.Getter;

@Getter
public class NutinfoResponseDto {
    private Long id;
    private String foodname;
    private String calories;
    private String carbohydrate;
    private String protein;
    private String fat;
    private String allergic;
    private String standard;

    public NutinfoResponseDto(Nutinfo entity) {
        this.id = entity.getId();
        this.foodname = entity.getFoodname();
        this.calories = entity.getCalories();
        this.carbohydrate = entity.getCarbohydrate();
        this.protein = entity.getProtein();
        this.fat = entity.getFat();
        this.allergic = entity.getAllergic();
        this.standard = entity.getStandard();
    }
}
