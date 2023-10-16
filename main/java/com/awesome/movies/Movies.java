package com.awesome.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies") /*this will inform framework that this class sheet
                                    represents each documents of the movies' collection.*/
@Data // handles all getters, setters and toStrings
@AllArgsConstructor // constructor for each class members
@NoArgsConstructor // a default constructor or no args
public class Movies {
    @Id  // sets the ID or PK
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private List<String>  genres;
    private List<String> backdrops;
    @DocumentReference
    /*This creates a one-to-many relationship between movies and reviews.
    * Here we are doing manual reference relationship.
    * so this will cause the database to only store the IDs of the movies.
    * And the reviews will be on separate collection*/
    private List<Reviews> reviewIds;


}
