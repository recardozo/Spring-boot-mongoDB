package com.mongo.payhere.domain;


import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection="user")
public class User implements Serializable {
    
    private String id;
    private String nome;
    private String email;
    
    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<> ();
    
    
    public User () {
    }
    
    public User (String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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
    
    public List<Post> getPosts () {
        return posts;
    }
    
    public void setPosts (List<Post> posts) {
        this.posts = posts;
    }
    
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        User user = (User) o;
        return id.equals (user.id);
    }
    
    @Override
    public int hashCode () {
        return Objects.hash (id);
    }
}
