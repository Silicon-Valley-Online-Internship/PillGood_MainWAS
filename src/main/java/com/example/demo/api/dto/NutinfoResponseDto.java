package com.example.demo.api.dto;

import com.example.demo.domain.Nutinfo;
import lombok.Getter;

@Getter
public class NutinfoResponseDto {
    private Long id;
    private String foodName;
    private String calories;
    private String carbohydrate;
    private String protein;
    private String fat;

    public NutinfoResponseDto(Nutinfo entity) {
        this.id = entity.getId();
        this.foodName = entity.getFoodName();
        this.calories = entity.getCalories();
        this.carbohydrate = entity.getCarbohydrate();
        this.protein = entity.getProtein();
        this.fat = entity.getFat();
    }
}
