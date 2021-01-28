package com.example.demo.api;

import com.example.demo.api.dto.ImagePredictResponseDto;
import com.example.demo.domain.json.Jsonhandler;
import com.example.demo.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
public class FileUploadController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    // Service URL -> Changeable
    private static final String flaskUrl = "http://flaskservice:5000/fileUpload";
    private static final String dbSearchURL = "http://localhost:8080/search/nut/name/{foodname}";

    @Autowired
    private FileUploadService service;

    @GetMapping("/springhello")
    public String hello() {
        return "HelloSpring";
    }

    @GetMapping("/hello")
    public String helloTest() {
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.exchange("http://flaskservice:5000/hello",
                HttpMethod.GET, requestEntity, String.class);

        return responseEntity.getBody();
    }

    @GetMapping("/uploadFile/Test")
    public String uploadControllerMain() {
        return "Hello, This is UploadImageAPI Main";
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<ImagePredictResponseDto> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        logger.info("Success Receiving Image");

        // Flask API Caller Test
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", file.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.exchange(flaskUrl,
                HttpMethod.POST, requestEntity, String.class);
        logger.info("Success Receive predict Result from FlaskAPI Server");

        String predict = Jsonhandler.parsingPredict(responseEntity);
        logger.info("####FLASK API PREDICT : " + predict);
        RestTemplate dbTemplate = new RestTemplate();
        String dbReutrn = dbTemplate.getForObject(dbSearchURL, String.class, predict);
        logger.info("Success Data Loading from NUTINFO Database");

        ImagePredictResponseDto responseDto = new ImagePredictResponseDto(predict, dbReutrn);

        return new ResponseEntity<ImagePredictResponseDto>(responseDto, HttpStatus.OK);
    }


}