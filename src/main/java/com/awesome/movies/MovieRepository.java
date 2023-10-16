package com.awesome.movies;

/* Service class and repository class will be used
 *  to get data from database*/

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/*Repositories are interface type which is a generic type
* this interface extends Mongo Repository and we have to
* specify what type and what ID*/
@Repository //annotate this as a repository
public interface MovieRepository extends MongoRepository<Movies, ObjectId> {
    /*Now we want to search a movie by imbdId because we dont want to expose Object id
    * But this does not come built-in. so we have to create our own function
    * */
    Optional<Movies> findByImdbId(String imdbId); //Optional because there could be no movies, and it will cause error
}
