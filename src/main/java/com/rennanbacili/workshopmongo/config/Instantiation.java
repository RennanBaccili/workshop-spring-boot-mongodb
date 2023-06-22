package com.rennanbacili.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rennanbacili.workshopmongo.domain.User;
import com.rennanbacili.workshopmongo.repository.UserRepository;

 @Configuration
public class Instantiation implements CommandLineRunner{
// para adicionar dados ao banco de dados sempre que iniciar o programa 
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		// TODO Auto-generated method stub
		User maria = new User(null, "Maria Brown", "mari@gmail.com");
		User alex = new User(null, "Alex Grey", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
	}

}
