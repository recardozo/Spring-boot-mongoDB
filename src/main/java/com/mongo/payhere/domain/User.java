package com.mongo.payhere.domain;

//import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;


public class User implements Serializable {
    
    private String id;
    private String nome;
    private String email;
    
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
