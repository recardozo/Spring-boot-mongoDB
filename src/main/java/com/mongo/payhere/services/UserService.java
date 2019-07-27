package com.mongo.payhere.services;

import com.mongo.payhere.domain.User;
import com.mongo.payhere.repositories.UserRepository;
import com.mongo.payhere.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> getUsers() {
		return repository.findAll();
	}

	public User getById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException ("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repository.save (obj);
	}

	public void delete(String id) {
		getById (id);
		repository.deleteById(id);
	}

	public User update(User obj) {
		User newObj = getById (obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(User newObj, User obj) {
		newObj.setNome (obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
//
//	public User fromDTO(UserDTO objDto) {
//		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
//	}
}