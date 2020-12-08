package com.example.currency.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rates {

    public Integer Cur_ID;
    public String Date;
    public String Cur_Abbreviation;
    public Double Cur_Scale;
    public String Cur_Name;
    public Double Cur_OfficialRate;

    public static Rates fromJson(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Rates rates = null;
        try {
            rates = objectMapper.readValue(json, Rates.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rates;
    }
}
