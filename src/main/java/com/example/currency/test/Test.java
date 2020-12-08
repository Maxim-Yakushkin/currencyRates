package com.example.currency.test;

import com.example.currency.entity.Rates;
import com.example.currency.entity.ResponseData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.springframework.boot.json.GsonJsonParser;

import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        GsonJsonParser gsonJsonParser = new GsonJsonParser();
        Gson gson = new Gson();
        String string = "[{\"Cur_ID\":170,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"AUD\",\"Cur_Scale\":1,\"Cur_Name\":\"Австралийский доллар\",\"Cur_OfficialRate\":1.8959},{\"Cur_ID\":191,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"BGN\",\"Cur_Scale\":1,\"Cur_Name\":\"Болгарский лев\",\"Cur_OfficialRate\":1.5875},{\"Cur_ID\":290,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"UAH\",\"Cur_Scale\":100,\"Cur_Name\":\"Гривен\",\"Cur_OfficialRate\":9.0940},{\"Cur_ID\":291,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"DKK\",\"Cur_Scale\":10,\"Cur_Name\":\"Датских крон\",\"Cur_OfficialRate\":4.1708},{\"Cur_ID\":145,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"USD\",\"Cur_Scale\":1,\"Cur_Name\":\"Доллар США\",\"Cur_OfficialRate\":2.5674},{\"Cur_ID\":292,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"EUR\",\"Cur_Scale\":1,\"Cur_Name\":\"Евро\",\"Cur_OfficialRate\":3.1076},{\"Cur_ID\":293,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"PLN\",\"Cur_Scale\":10,\"Cur_Name\":\"Злотых\",\"Cur_OfficialRate\":6.9366},{\"Cur_ID\":355,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"JPY\",\"Cur_Scale\":100,\"Cur_Name\":\"Иен\",\"Cur_OfficialRate\":2.4617},{\"Cur_ID\":303,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"IRR\",\"Cur_Scale\":100000,\"Cur_Name\":\"Иранских риалов\",\"Cur_OfficialRate\":6.1129},{\"Cur_ID\":294,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"ISK\",\"Cur_Scale\":100,\"Cur_Name\":\"Исландских крон\",\"Cur_OfficialRate\":2.0410},{\"Cur_ID\":23,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"CAD\",\"Cur_Scale\":1,\"Cur_Name\":\"Канадский доллар\",\"Cur_OfficialRate\":2.0028},{\"Cur_ID\":304,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"CNY\",\"Cur_Scale\":10,\"Cur_Name\":\"Китайских юаней\",\"Cur_OfficialRate\":3.9255},{\"Cur_ID\":72,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"KWD\",\"Cur_Scale\":1,\"Cur_Name\":\"Кувейтский динар\",\"Cur_OfficialRate\":8.4296},{\"Cur_ID\":296,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"MDL\",\"Cur_Scale\":10,\"Cur_Name\":\"Молдавских леев\",\"Cur_OfficialRate\":1.4823},{\"Cur_ID\":286,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"NZD\",\"Cur_Scale\":1,\"Cur_Name\":\"Новозеландский доллар\",\"Cur_OfficialRate\":1.8009},{\"Cur_ID\":297,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"NOK\",\"Cur_Scale\":10,\"Cur_Name\":\"Норвежских крон\",\"Cur_OfficialRate\":2.8932},{\"Cur_ID\":298,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"RUB\",\"Cur_Scale\":100,\"Cur_Name\":\"Российских рублей\",\"Cur_OfficialRate\":3.4560},{\"Cur_ID\":299,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"XDR\",\"Cur_Scale\":1,\"Cur_Name\":\"СДР (Специальные права заимствования)\",\"Cur_OfficialRate\":3.6952},{\"Cur_ID\":119,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"SGD\",\"Cur_Scale\":1,\"Cur_Name\":\"Сингапурcкий доллар\",\"Cur_OfficialRate\":1.9180},{\"Cur_ID\":300,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"KGS\",\"Cur_Scale\":100,\"Cur_Name\":\"Сомов\",\"Cur_OfficialRate\":3.0266},{\"Cur_ID\":301,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"KZT\",\"Cur_Scale\":1000,\"Cur_Name\":\"Тенге\",\"Cur_OfficialRate\":6.0819},{\"Cur_ID\":302,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"TRY\",\"Cur_Scale\":10,\"Cur_Name\":\"Турецких лир\",\"Cur_OfficialRate\":3.2723},{\"Cur_ID\":143,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"GBP\",\"Cur_Scale\":1,\"Cur_Name\":\"Фунт стерлингов\",\"Cur_OfficialRate\":3.4057},{\"Cur_ID\":305,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"CZK\",\"Cur_Scale\":100,\"Cur_Name\":\"Чешских крон\",\"Cur_OfficialRate\":11.6987},{\"Cur_ID\":306,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"SEK\",\"Cur_Scale\":10,\"Cur_Name\":\"Шведских крон\",\"Cur_OfficialRate\":3.0226},{\"Cur_ID\":130,\"Date\":\"2020-12-08T00:00:00\",\"Cur_Abbreviation\":\"CHF\",\"Cur_Scale\":1,\"Cur_Name\":\"Швейцарский франк\",\"Cur_OfficialRate\":2.8736}]";
        StringBuilder response = new StringBuilder();

        List<Object> parseList = gsonJsonParser.parseList(string);
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


//        System.out.println(parseList);
//        System.out.println();
//        System.out.println(collect);
//        System.out.println();
//        System.out.println(ratesList);
//        System.out.println();
//        System.out.println("Список строк");
//        for (Object o : parseList) {
//            System.out.println(o);
//        }
//        System.out.println();
//
//        System.out.println("Список json");
//        for (String s : collect) {
//            System.out.println(s);
//        }
//        System.out.println();

        System.out.println("Курс валют");
        for (Rates rates : ratesList) {
            ResponseData data = ResponseData.builder()
                    .curName(rates.Cur_Name)
                    .curOfficialRate(rates.Cur_OfficialRate)
                    .build();
            response.append(String.format("%s: %s", data.getCurName(), data.getCurOfficialRate())).append("\n");
        }
        System.out.println(response);
    }
}
