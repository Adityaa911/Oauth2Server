package org.example.oauth2server.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.oauth2server.Models.Tokens;

@Getter
@Setter
public class LogoutRequestDto {
    private String tokens;
}
