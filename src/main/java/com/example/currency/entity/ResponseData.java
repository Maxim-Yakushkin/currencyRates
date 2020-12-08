package com.example.currency.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {

    private String curName;
    private Double curOfficialRate;
    private Double cur_Scale;
    private String cur_Abbreviation;
}
