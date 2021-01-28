package com.example.demo.api.dto;

import lombok.Getter;

@Getter
public class FileUploadResponseDto {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public FileUploadResponseDto(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }
}
