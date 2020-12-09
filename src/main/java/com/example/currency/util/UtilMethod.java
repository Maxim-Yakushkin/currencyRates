package com.example.currency.util;

import com.example.currency.entity.Rates;
import com.example.currency.entity.ResponseData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class UtilMethod {

    public static String formatResponseData(List<Rates> ratesList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Rates rates : ratesList) {
            ResponseData data = ResponseData.builder()
                    .curName(rates.Cur_Name)
                    .curOfficialRate(rates.Cur_OfficialRate)
                    .cur_Scale(rates.Cur_Scale)
                    .cur_Abbreviation(rates.Cur_Abbreviation)
                    .build();
            stringBuilder.append(String.format("%s: <b>%s</b> (за %s %s)",
                    data.getCurName(),
                    data.getCurOfficialRate(),
                    data.getCur_Scale(),
                    data.getCur_Abbreviation()))
                    .append("</br>");
        }

        return stringBuilder.toString();
    }

    public static List<Rates> getRatesList(String value) {
        Gson gson = new Gson();
        List<Object> parseList = gson.fromJson(value, List.class);
        return parseList.stream()
                .map(gson::toJson)
                .collect(Collectors.toList())
                .stream()
                .map(x -> {
                    try {
                        return Rates.fromJson(x);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }

    public static String getStringResponse(HttpURLConnection connection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseHttp = new StringBuilder();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            responseHttp.append(line);
        }

        return responseHttp.toString();
    }

    public static HttpURLConnection getHttpURLConnection(String http) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(http).openConnection();

        connection.setRequestMethod("GET");
        connection.setUseCaches(false);
        connection.setConnectTimeout(25000);
        connection.setReadTimeout(25000);

        connection.connect();

        return connection;
    }
}
