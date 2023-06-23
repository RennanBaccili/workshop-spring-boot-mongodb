package com.rennanbacili.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rennanbacili.workshopmongo.domain.Post;
import com.rennanbacili.workshopmongo.domain.User;
import com.rennanbacili.workshopmongo.repository.PostRepository;
import com.rennanbacili.workshopmongo.repository.UserRepository;

 @Configuration
public class Instantiation implements CommandLineRunner{
// para adicionar dados ao banco de dados sempre que iniciar o programa 
	
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
		// TODO Auto-generated method stub
		User maria = new User(null, "Maria Brown", "mari@gmail.com");
		User alex = new User(null, "Alex Grey", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo abraço", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei Feliz hoje", maria);
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		postRepository.saveAll(Arrays.asList(post1,post2));
		
	}

}
