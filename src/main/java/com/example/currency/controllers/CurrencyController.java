package com.example.currency.controllers;

import com.example.currency.entity.Rates;
import com.example.currency.util.UtilMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

@RestController
@RequestMapping()
public class CurrencyController {

    @GetMapping("currencyRatesNbrb")
    public String currencyRates(@RequestParam(value = "request", defaultValue = "https://www.nbrb.by/api/exrates/rates?periodicity=0") String request) throws IOException {

        HttpURLConnection connection = UtilMethod.getHttpURLConnection(request);
        String stringResponse = UtilMethod.getStringResponse(connection);
        List<Rates> ratesList = UtilMethod.getRatesList(stringResponse);

        return UtilMethod.formatResponseData(ratesList);
    }

    @GetMapping("request")
    public String request(@RequestParam(value = "value", defaultValue = "") String request) throws IOException {
        HttpURLConnection httpURLConnection;
        String response;

        if (!request.isEmpty()) {
            httpURLConnection = UtilMethod.getHttpURLConnection(request);
            response = UtilMethod.getStringResponse(httpURLConnection);
        } else {
            response = "Запрос отсутствует";
        }

        return response;
    }


}
