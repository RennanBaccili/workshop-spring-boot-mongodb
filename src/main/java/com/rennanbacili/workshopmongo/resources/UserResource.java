package com.rennanbacili.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rennanbacili.workshopmongo.domain.User;
import com.rennanbacili.workshopmongo.dto.UserDTO;
import com.rennanbacili.workshopmongo.services.UserService;

@RestController
@RequestMapping(value ="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET) // metodo get é para obter informaçoes
	public ResponseEntity<List<UserDTO>> findAll() { // response entity encapsula toda a estruta necessaria para retornar estrutura http
		List<User> list = service.findeAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}