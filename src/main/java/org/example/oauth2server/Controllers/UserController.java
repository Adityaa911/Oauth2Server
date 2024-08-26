package org.example.oauth2server.Controllers;

import org.example.oauth2server.Dtos.*;
import org.example.oauth2server.Models.Tokens;
import org.example.oauth2server.Models.User;
import org.example.oauth2server.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public SignupResponseDto SignUp(@RequestBody SignUpRequestDto requestDto) {
        User user = userService.SignUp(
                requestDto.
                getName(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        SignupResponseDto responseDto = new SignupResponseDto();

        responseDto.setUser(user);
        responseDto.setResponseStatus(ReponseStatus.SUCCESS);

        return responseDto;
    }

    @PostMapping("/login")
    public loginResponseDto Login(@RequestBody loginRequestDto requestDto) {
        Tokens tokens = userService.Login(
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        loginResponseDto responseDto = new loginResponseDto();
        responseDto.setTokens(tokens);

        return responseDto;
    }

    @GetMapping("/validate/{token}")
    public UserDto ValidateToken(@PathVariable("token") ValidateTokenRequestDto requestDto) {
        User user = userService.ValidateToken(requestDto.getToken());

        return UserDto.fromUser(user);
    }


    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto requestDto) {

        ResponseEntity<Void> responseEntity = null;
        try {
            userService.Logout(requestDto.getTokens());

            responseEntity = new ResponseEntity<>(
                    HttpStatus.OK
            );
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(
                    HttpStatus.UNAUTHORIZED
            );
        }
        return responseEntity;
    }

    @PostMapping("/Forget-Password")
    public String ForgetPassword(@RequestBody ForgetPassRequestDto requestDto) {
        String response = userService.ForgetPassword(requestDto.getEmail());

        if (!response.equals("success")){
            response ="http://localhost:8080/reset-password?token" + response;
        }
        return response;
    }

    @PutMapping("/Reset-Password")
    public String ResetPassword(@RequestParam String Token,@RequestParam String Password) {
        return userService.ResetPassword(Token,Password);
    }

}
