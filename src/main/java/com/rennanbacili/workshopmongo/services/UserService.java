package com.rennanbacili.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rennanbacili.workshopmongo.domain.User;
import com.rennanbacili.workshopmongo.dto.UserDTO;
import com.rennanbacili.workshopmongo.repository.UserRepository;
import com.rennanbacili.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	
	public List<User> findeAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		// primeiro passo eu instancio o obj e vou buscalo no banco de dados
		User newObj = findById(obj.getId());
		// vou buscalo para atualizalo
		//metodo para atualizar o novo obj e o obj que foi passado
		updateData(newObj, obj);
		// para poder salvar o obj novo
		return repo.save(newObj);
		}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	// por motivos de manutenlção futura o from DTO vai ficar na classe service
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
