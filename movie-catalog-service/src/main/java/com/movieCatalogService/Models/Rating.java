package com.movieCatalogService.Models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Rating {
    private String movieId;
    private int rating;
}
