package com.awesome.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository //annotate the interface as a repository
public interface ReviewsRepository extends MongoRepository<Reviews, ObjectId> {

}
