package org.example.oauth2server.Security.Models;

import org.example.oauth2server.Models.Roles;
import org.springframework.security.core.GrantedAuthority;

public class CustomGrantAuthority implements GrantedAuthority {

    private String authority;

     CustomGrantAuthority(Roles roles){
        this.authority=roles.getName();
    }
    @Override
    public String getAuthority() {
        return authority;
    }
}
