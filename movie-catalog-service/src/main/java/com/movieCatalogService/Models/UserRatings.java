package com.movieCatalogService.Models;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class UserRatings {
    private List<Rating> userRatings;
}
