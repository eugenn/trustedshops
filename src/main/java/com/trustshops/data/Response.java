package com.trustshops.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created by eugennekhai on 10/02/2017.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private Integer code;
    private ShopData data;

    public Response() {}
}
