package com.mongo.payhere.resources;

import com.mongo.payhere.domain.User;
import com.mongo.payhere.dto.UserDTO;
import com.mongo.payhere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @Autowired
    UserService service;
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers () {
        List<User> users=service.getUsers ();
        List<UserDTO> usersDTO= users.stream ().map (user -> new UserDTO (user)).collect(Collectors.toList());
        return ResponseEntity.ok().body (usersDTO);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser (@PathVariable String id ) {
        User user = service.getById (id);
        return ResponseEntity.ok().body (new UserDTO (user));
    }
    
}
