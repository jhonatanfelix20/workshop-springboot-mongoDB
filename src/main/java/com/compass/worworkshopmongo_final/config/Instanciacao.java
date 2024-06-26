package com.compass.worworkshopmongo_final.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.compass.workshopmongo_final.domain.Post;
import com.compass.workshopmongo_final.domain.User;
import com.compass.worworkshopmongo_final.dto.AutorDTO;
import com.compass.worworkshopmongo_final.dto.ComentarioDTO;
import com.compass.worworkshopmongo_final.repository.PostRepository;
import com.compass.worworkshopmongo_final.repository.UserRepository;

@Configuration
public class Instanciacao implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AutorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AutorDTO(maria));
		
		ComentarioDTO c1 = new ComentarioDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AutorDTO(alex));
		ComentarioDTO c2 = new ComentarioDTO("Aproveite", sdf.parse("22/03/2018"), new AutorDTO(bob));
		ComentarioDTO c3 = new ComentarioDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AutorDTO(alex));
		
		post1.getCometario().addAll(Arrays.asList(c1,c2));
		post2.getCometario().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
