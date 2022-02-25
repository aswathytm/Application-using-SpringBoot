package com.example.PetStore.User.SecurityConfiguration;


import com.example.PetStore.User.Model.UserModel;
import com.example.PetStore.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceSecurity implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> user = userRepository.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return new UserModel(user.get());
    }
}