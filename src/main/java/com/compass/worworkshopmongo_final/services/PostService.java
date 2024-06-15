package com.compass.worworkshopmongo_final.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.workshopmongo_final.domain.Post;
import com.compass.worworkshopmongo_final.repository.PostRepository;
import com.compass.worworkshopmongo_final.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitulo(String text){
		return repo.findByTituloContainingIgnoreCase(text);
	}

}
