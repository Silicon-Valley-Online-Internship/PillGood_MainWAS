package com.example.demo.domain.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

public class Jsonhandler {

    public static String parsingPredict(ResponseEntity<String> responseEntity) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String responseBody = responseEntity.getBody();
        PredictData value = mapper.readValue(responseBody, PredictData.class);

        return value.getPredict();
    }
}

@Getter @Setter
@Data
class PredictData {
    @JsonProperty("Predict")
    String predict;
}