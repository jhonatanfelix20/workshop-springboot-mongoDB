package com.compass.worworkshopmongo_final.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.compass.workshopmongo_final.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Post> tituloPesquisado(String text);
	
	List<Post> findByTituloContainingIgnoreCase(String text);
	
	@Query("{ $and: [ { data: {$gte: ?1} }, { data: { $lte: ?2 } }, { $or: [ {'titulo': { $regex: ?0, $options: 'i' } }, {'body': { $regex: ?0, $options: 'i' } }, {'comentario.text': { $regex: ?0, $options: 'i' }} ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxdate);
	
}
