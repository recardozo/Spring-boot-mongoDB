package com.mongo.payhere.resources;

import com.mongo.payhere.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers () {
        User maria = new User ("1", "Maria", "maria@hotmail.com");
        List<User> users = new ArrayList<> ();
        users.add (maria);
        return ResponseEntity.ok().body (users);
    }
}
