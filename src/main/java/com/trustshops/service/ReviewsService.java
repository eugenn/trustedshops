package com.trustshops.service;

import com.trustshops.data.RespWrapper;
import com.trustshops.data.Review;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by eugennekhai on 10/02/2017.
 */
@Service
public class ReviewsService {
    private static String URL = "https://api.trustedshops.com/rest/public/v2/shops/%1$s/reviews.json";

    public List<Review> reviews(String id) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        RespWrapper obj = restTemplate.getForObject(String.format(URL, id), RespWrapper.class);

        return obj.getResponse().getData().getShop().getReviews();
    }

}
