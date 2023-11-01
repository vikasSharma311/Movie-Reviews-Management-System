package com.movieCatalogService.Controller;

import com.movieCatalogService.Models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


@RestController
public class MovieCatalogController {
    @RequestMapping("/catalog/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId){
//        CatalogItem catalogItem = CatalogItem.builder().name("Tranformers").desc("Test").rating(4).build();
//        return catalogItem;
        return Collections.singletonList(
                new CatalogItem("Tranformers","Test",4)
        );


    }
}
