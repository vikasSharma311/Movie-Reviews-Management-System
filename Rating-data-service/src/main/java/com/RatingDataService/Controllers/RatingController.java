package com.RatingDataService.Controllers;

import com.RatingDataService.models.Rating;
import com.RatingDataService.models.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {

        return new Rating(movieId, 4);
    }
    @RequestMapping("/users/{userId}")
    public UserRatings getUserRating(@PathVariable("userId") String userId) {
       List<Rating> ratings= Arrays.asList(
                new Rating("1234",4),
                new Rating("56789",5)
        );
        UserRatings userRatings = UserRatings.builder().userRatings(ratings).build();
        return userRatings;
    }
}

