package com.trustshops.controller;

import com.trustshops.data.Review;
import com.trustshops.service.ReviewFilter;
import com.trustshops.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by eugennekhai on 10/02/2017.
 */
@Controller
public class ReviewsController {
    @Autowired
    private ReviewsService reviewsService;
    @Autowired
    private ReviewFilter reviewFilter;

    @RequestMapping(value = "/reviews/{shopId}", method= RequestMethod.GET)
    @ResponseBody
    public List<Review> extractReviews(@PathVariable String shopId) throws IOException {
        List<Review> reviews = reviewsService.reviews(shopId);

        return reviewFilter.apply(reviews);
    }
}
