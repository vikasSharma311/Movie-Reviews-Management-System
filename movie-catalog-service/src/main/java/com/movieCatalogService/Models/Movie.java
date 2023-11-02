package com.movieCatalogService.Models;

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
