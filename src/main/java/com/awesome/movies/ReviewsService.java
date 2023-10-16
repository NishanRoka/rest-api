package com.awesome.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //annotate the class as a service class
public class ReviewsService {
    @Autowired
    public ReviewsRepository reviewsRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    //Create a review
    public Reviews createReview(String reviewBody, String imdbId){
        //Create a new review and insert with insert method
        Reviews review = reviewsRepository.insert(new Reviews(reviewBody));

        //Insert it into the database
        mongoTemplate.update(Movies.class) //select which class to update
                .matching(Criteria.where("imdbId").is(imdbId)) //check whether we are updating the correct movie
                .apply(new Update().push("reviewIds").value(review)) // insert reviewId into the database and put the review
                .first(); //It assures we are getting a single movie and we are updating that

        return review;
    }

}
