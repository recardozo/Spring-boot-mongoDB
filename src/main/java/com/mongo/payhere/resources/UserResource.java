package com.mongo.payhere.resources;

import com.mongo.payhere.domain.Post;
import com.mongo.payhere.domain.User;
import com.mongo.payhere.dto.UserDTO;
import com.mongo.payhere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @Autowired
    UserService service;
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers () {
        List<User> users = service.getUsers ();
        List<UserDTO> usersDTO = users.stream ().map (user -> new UserDTO (user)).collect (Collectors.toList ());
        return ResponseEntity.ok ().body (usersDTO);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser (@PathVariable String id) {
        User user = service.getById (id);
        return ResponseEntity.ok ().body (new UserDTO (user));
    }
    
    @PostMapping
    public ResponseEntity<UserDTO> getUser (@RequestBody UserDTO userDTO) {
        User user = service.fromDTO (userDTO);
        user = service.create (user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest ().path ("/{id}").buildAndExpand (user.getId ()).toUri ();
        return ResponseEntity.created (uri).build ();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable String id) {
        service.delete (id);
        return ResponseEntity.noContent ().build ();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> update (@RequestBody UserDTO userDto, @PathVariable String id) {
        User user = service.fromDTO (userDto);
        user.setId (id);
        user = service.update (user);
        return ResponseEntity.noContent ().build ();
    }
    
    @GetMapping(value="/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User user = service.getById (id);
        return ResponseEntity.ok().body(user.getPosts());
    }
}
