package com.awesome.movies;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  //annotate the class as controller
@RequestMapping("/api/v1/movies")  //all the request made to this end will be responded
@CrossOrigin(origins = "*")
public class MoviesController {
    @Autowired //Instantiate service class
    private MoviesService moviesService;
    @GetMapping  //this method will be the response to the above-mentioned endpoint
    public ResponseEntity<List<Movies>> getAllMovies(){
        return new ResponseEntity<List<Movies>>(moviesService.allMovies(), HttpStatus.OK);
    }

    //@Path Variable informs the framework that whatever is given in @GetMapping will be used as parameter of the func
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movies>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movies>>(moviesService.singleMovie(imdbId), HttpStatus.OK);
    }
}
