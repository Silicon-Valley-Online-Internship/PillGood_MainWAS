package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Nutinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String foodname;

    @Column(nullable = false)
    private String calories;

    @Column(nullable = false)
    private String carbohydrate;

    @Column(nullable = false)
    private String protein;

    @Column(nullable = false)
    private String fat;

    @Builder
    public Nutinfo(String foodname, String calories, String carbohydrate,
                   String protein, String fat) {
        this.foodname = foodname;
        this.calories = calories;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
    }

    public void update(String foodname, String calories, String carbohydrate,
                       String protein, String fat) {
        this.foodname = foodname;
        this.calories = calories;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
    }
}
