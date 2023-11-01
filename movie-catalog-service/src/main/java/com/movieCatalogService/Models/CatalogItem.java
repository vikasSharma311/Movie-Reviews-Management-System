package com.movieCatalogService.Models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CatalogItem {
    private String name;
    private String desc;
    private int rating;

}
