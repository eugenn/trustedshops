package com.trustshops.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Created by eugennekhai on 10/02/2017.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shop {
    private String tsId;
    private String url;
    private String name;
    private String languageISO2;
    private String targetMarketISO3;

    private List<Review> reviews;

    public Shop(){}
}
