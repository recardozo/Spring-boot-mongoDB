package com.mongo.payhere.dto;

import com.mongo.payhere.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    
    private String id;
    private String nome;
    private String email;
    
    public UserDTO () {
    }
    
    public UserDTO (User user) {
        this.id = user.getId ();
        this.nome = user.getNome ();
        this.email = user.getEmail ();
    }
    
    public String getId () {
        return id;
    }
    
    public void setId (String id) {
        this.id = id;
    }
    
    public String getNome () {
        return nome;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public String getEmail () {
        return email;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
}
