package org.example.oauth2server.Security.Service;

import org.example.oauth2server.Models.User;
import org.example.oauth2server.Repository.UserRepository;
import org.example.oauth2server.Security.Models.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    CustomUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(optionalUser.get());
    }
}
