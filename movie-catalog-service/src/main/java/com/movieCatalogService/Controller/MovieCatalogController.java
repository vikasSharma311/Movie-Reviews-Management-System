package com.movieCatalogService.Controller;

import com.movieCatalogService.Models.CatalogItem;
import com.movieCatalogService.Models.Movie;
import com.movieCatalogService.Models.Rating;
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
        List<Rating> ratings= Arrays.asList(
                new Rating("1234",4),
                new Rating("56789",5)
        );

        return ratings.stream().map(rating -> {
//            Movie movie = restTemplate.getForObject("http://localhost:9091/movies/"+rating.getMovieId(), Movie.class);

            //Alternative way Webclient:Reactive Programming:asynchronous
            Movie movie = builder.build().get()
                    .uri("http://localhost:9091/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
            return  CatalogItem.builder().name(movie.getName()).desc("Description").rating(rating.getRating()).build();
        }).collect(Collectors.toList());


    }
}
