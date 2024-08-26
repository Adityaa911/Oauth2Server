package org.example.oauth2server.Security.Models;

import org.example.oauth2server.Models.Roles;
import org.example.oauth2server.Models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private List<GrantedAuthority> grantedAuthorities;
    private String password;
    private String userName;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
   private Boolean isCredentialsNonExpired;
   private Boolean isEnabled;

   public CustomUserDetails(User user){
       this.password=user.getHashedPassword();
       this.userName=user.getEmail();
       this.isEnabled=true;
       this.isAccountNonExpired=true;
       this.isAccountNonLocked=true;
       this.isCredentialsNonExpired=true;

       this.grantedAuthorities =new ArrayList<>();

       for(Roles roles : grantedAuthorities){
           grantedAuthorities.add(new CustomGrantAuthority(roles));
       }
   }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
