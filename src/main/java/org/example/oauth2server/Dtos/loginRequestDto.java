package org.example.oauth2server.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class loginRequestDto {

    private String Email;
    private String Password;
}
