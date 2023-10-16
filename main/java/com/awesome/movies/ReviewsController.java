package com.awesome.movies;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "*")
public class ReviewsController {
    @Autowired
    private ReviewsService reviewsService;

    @PostMapping
    public ResponseEntity<Reviews> createReview(@RequestBody @NotNull Map<String, String> payload){
        return new ResponseEntity<Reviews>(reviewsService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }



}
