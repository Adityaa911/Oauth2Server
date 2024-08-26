package org.example.oauth2server.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModel{

    private String name;
    private String email;
    private String HashedPassword;
    @ManyToMany
    private List<Roles> roles;
}
