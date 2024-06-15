package com.compass.worworkshopmongo_final.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.compass.workshopmongo_final.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
