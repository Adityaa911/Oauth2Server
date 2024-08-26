package org.example.oauth2server.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.oauth2server.Models.Tokens;
import org.example.oauth2server.Models.User;

@Getter
@Setter
public class loginResponseDto {
    private Tokens tokens;
}
