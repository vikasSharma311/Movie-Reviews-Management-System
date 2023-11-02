package com.movieCatalogService.Controller;

import com.movieCatalogService.Models.CatalogItem;
import com.movieCatalogService.Models.Movie;
import com.movieCatalogService.Models.Rating;
import com.movieCatalogService.Models.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class MovieCatalogController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder builder;
    @RequestMapping("/catalog/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId){
        UserRatings ratings= restTemplate.getForObject("http://localhost:9093/ratingsdata/users/"+userId, UserRatings.class);

        return ratings.getUserRatings().stream().map(rating -> {
            //For Each Movie Id ,call movie info Service and get details
            Movie movie = restTemplate.getForObject("http://localhost:9091/movies/"+rating.getMovieId(), Movie.class);
            //Put them all together
            return  CatalogItem.builder().name(movie.getName()).desc("Description").rating(rating.getRating()).build();
        }).collect(Collectors.toList());


    }
}

//Alternative way Webclient:Reactive Programming:asynchronous
//            Movie movie = builder.build().get()
//                    .uri("http://localhost:9091/movies/" + rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block();