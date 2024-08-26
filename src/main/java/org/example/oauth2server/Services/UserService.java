package org.example.oauth2server.Services;

import org.example.oauth2server.Models.Tokens;
import org.example.oauth2server.Models.User;


public interface UserService {

     User SignUp(String name, String email, String password);

    Tokens Login(String email, String password);
 
     User ValidateToken(String token);

     void Logout(String token);

     String ForgetPassword(String email);

    String ResetPassword(String Token,String password);
}
