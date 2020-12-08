package com.example.currency.controllers;

import com.example.currency.entity.Rates;
import com.example.currency.entity.ResponseData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping()
public class CurrencyController {

    @GetMapping("currency")
    public String list() {
        StringBuilder responseHttp = new StringBuilder();
        GsonJsonParser gsonJsonParser = new GsonJsonParser();
        Gson gson = new Gson();
        StringBuilder responseData = new StringBuilder();

        try {
            String query = "https://www.nbrb.by/api/exrates/rates?periodicity=0";
            HttpURLConnection connection = (HttpURLConnection) new URL(query).openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(25000);
            connection.setReadTimeout(25000);

            connection.connect();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                responseHttp.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Object> parseList = gsonJsonParser.parseList(responseHttp.toString());
        List<String> collect = parseList.stream()
                .map(gson::toJson)
                .collect(Collectors.toList());
        List<Rates> ratesList = collect.stream()
                .map(x -> {
                    try {
                        return Rates.fromJson(x);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());

        for (Rates rates : ratesList) {
            ResponseData data = ResponseData.builder()
                    .curName(rates.Cur_Name)
                    .curOfficialRate(rates.Cur_OfficialRate)
                    .cur_Scale(rates.Cur_Scale)
                    .cur_Abbreviation(rates.Cur_Abbreviation)
                    .build();
            responseData.append(String.format("%s: <b>%s</b> (за %s %s)", data.getCurName(), data.getCurOfficialRate(), data.getCur_Scale(), data.getCur_Abbreviation())).append("</br>");
        }

        return responseData.toString();
    }
}
