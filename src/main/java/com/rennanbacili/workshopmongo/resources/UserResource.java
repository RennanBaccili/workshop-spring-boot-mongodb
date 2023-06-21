package com.rennanbacili.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rennanbacili.workshopmongo.domain.User;
import com.rennanbacili.workshopmongo.services.UserService;

@RestController
@RequestMapping(value ="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET) // metodo get é para obter informaçoes
	public ResponseEntity<List<User>> findAll() { // response entity encapsula toda a estruta necessaria para retornar estrutura http
		List<User> list = service.findeAll();
		return ResponseEntity.ok().body(list);
	}
}