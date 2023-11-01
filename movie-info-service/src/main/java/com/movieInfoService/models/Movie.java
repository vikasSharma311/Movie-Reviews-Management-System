package com.movieInfoService.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Movie {
    private String movieId;
    private String name;

}
