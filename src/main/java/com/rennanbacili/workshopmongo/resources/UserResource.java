package com.rennanbacili.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(value= "/{id}",method=RequestMethod.GET) // metodo get é para obter informaçoes
	public ResponseEntity<UserDTO> findById(@PathVariable String id) { // response entity encapsula toda a estruta necessaria para retornar estrutura http
		User obj =service.findById(id); // para encontrar id

		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	@RequestMapping(method=RequestMethod.POST) // metodo post para inserir informações
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO objDTO) { // response entity encapsula toda a estruta necessaria para retornar estrutura http
		User obj = service.fromDTO(objDTO);// para encontrar id
		obj = service.insert(obj);
		// vai pegar o objeto do novo endereço 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		// boas praticas, ele retorna codigo 201 e o url
	}
	@RequestMapping(value= "/{id}",method=RequestMethod.DELETE) // metodo get é para obter informaçoes
	public ResponseEntity<Void> delete(@PathVariable String id) { // response entity encapsula toda a estruta necessaria para retornar estrutura http
		service.delete(id); // para encontrar id

		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value= "/{id}",method=RequestMethod.PUT) 
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO objDTO, @PathVariable String id) { // response entity encapsula toda a estruta necessaria para retornar estrutura http
		User obj = service.fromDTO(objDTO);// para encontrar id
		obj.setId(id);
		obj = service.update(obj);
		// vai pegar o objeto do novo endereço 
		return ResponseEntity.noContent().build();
		// boas praticas, ele retorna codigo 201 e o url
	}
	
	
	
}