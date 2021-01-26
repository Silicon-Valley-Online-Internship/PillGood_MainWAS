package com.example.demo.api;

import com.example.demo.api.dto.FileUploadResponseDto;
import com.example.demo.api.dto.ImagePredictResponseDto;
import com.example.demo.domain.json.Jsonhandler;
import com.example.demo.service.FileUploadService;
import com.example.demo.service.NutinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;

@RestController
public class FileUploadController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    // Service URL -> Changeable
    private static final String flaskUrl = "http://localhost:5000/fileUpload";
    private static final String dbSearchURL = "http://localhost:8080/search/nut/name/{foodname}";

    @Autowired
    private FileUploadService service;

    @GetMapping("/uploadFile/Test")
    public String uploadControllerMain() {
        return "Hello, This is UploadImageAPI Main";
    }

    @PostMapping("/uploadFile")
    public ImagePredictResponseDto uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = service.storeFile(file);
        logger.info("Success Receiving Image");
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        // Flask API Caller Test
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        body.add("image", file.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.exchange(flaskUrl,
                HttpMethod.POST, requestEntity, String.class);
        logger.info("Success Receive predict Result from FlaskAPI Server");

        String predict = Jsonhandler.parsingPredict(responseEntity);
        RestTemplate dbTemplate = new RestTemplate();
        String dbReutrn = dbTemplate.getForObject(dbSearchURL, String.class, predict);
        logger.info("Success Data Loading from NUTINFO Database");

        return new ImagePredictResponseDto("{ predict : " + predict + " }",
                                            "{ NutritionInfo : " + dbReutrn + " }");
    }


}