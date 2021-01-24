package com.example.demo.api.dto;

import lombok.Getter;

@Getter
public class ImagePredictResponseDto {
    private String predict;
    private String predictNutinfo;

    public ImagePredictResponseDto(String predict, String predictNutinfo) {
        this.predict = predict;
        this.predictNutinfo = predictNutinfo;
    }
}
