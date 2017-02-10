package com.trustshops.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by eugennekhai on 10/02/2017.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {
    private Date changeDate;
    private String comment;
    private Date confirmationDate;
    private Date creationDate;
    private List<Criteria> criteria;
    private Float mark;
    private String markDescription;
    private String UID;

    public Review(){}
}
