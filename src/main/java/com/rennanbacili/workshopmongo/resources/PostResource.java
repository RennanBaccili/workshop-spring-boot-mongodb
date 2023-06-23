package com.rennanbacili.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rennanbacili.workshopmongo.domain.Post;
import com.rennanbacili.workshopmongo.resources.util.URL;
import com.rennanbacili.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/poste", method = RequestMethod.GET)
public class PostResource {

	@Autowired
	private PostService service;

	@RequestMapping(value= "/{id}",method=RequestMethod.GET) // metodo get é para obter informaçoes
	public ResponseEntity<Post> findById(@PathVariable String id) { // response entity encapsula toda a estruta necessaria para retornar estrutura http
		Post obj = service.findById(id);// para encontrar id

		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text",defaultValue = "") String text) {
		text = URL.decodeParam(text); //decodificador de texto
		List<Post> list = service.findByTitle(text);
		
		return ResponseEntity.ok().body(list);
	}
	
}