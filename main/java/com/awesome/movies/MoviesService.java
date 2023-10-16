package com.awesome.movies;

/* Service class and repository class will be used
*  to get data from database*/

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //annotate this class as service class. Inside we will write access methods
public class MoviesService {
    //we will need a reference of the repository

    //We have to initialize this bit of code or use autowired which will instantiate the class for us
    @Autowired
    private MovieRepository movieRepository;  //here Interface MovieRepository will be instantiated by the framework

    public List<Movies> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movies> singleMovie(String imdbId){
        return movieRepository.findByImdbId(imdbId);
    }


}
