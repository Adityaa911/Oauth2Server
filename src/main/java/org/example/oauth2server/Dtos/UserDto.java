package org.example.oauth2server.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.oauth2server.Models.Roles;
import org.example.oauth2server.Models.User;

import java.util.List;

@Getter
@Setter
public class UserDto {
   // public static UserDto fromUser;
    private String name;
    private String email;
    private List<Roles> roles;

    public static UserDto fromUser(User user) {

        if(user==null){
            return null;
        }

        UserDto userDto= new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());

        return userDto;
    }

}
