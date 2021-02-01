package com.example.demo.api.dto;

import lombok.Getter;

@Getter
public class ImagePredictResponseDto {
    private String predict;
    private String predictinfo;

    public ImagePredictResponseDto(String predict, String predictinfo) {
        this.predict = predict;
        this.predictinfo = predictinfo;
    }
}
