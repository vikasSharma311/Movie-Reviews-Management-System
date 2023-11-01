package com.movieInfoService.Controllers;

import com.movieInfoService.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @RequestMapping("/movies/{movieId}")
    public Movie getMovieInfo(@PathVariable String movieId){
        return Movie.builder().name("Test").movieId(movieId).build();
    }
}
