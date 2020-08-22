package com.example.demospringzdalne.service;

import com.example.demospringzdalne.model.LoginUser;
import com.example.demospringzdalne.repository.UserLoginRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    UserLoginRepository repo;
    private PasswordEncoder passwordEncoder;

    public UserLoginService(UserLoginRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public void addLoginUser(LoginUser user){
        user.setRole("ROLE_USER");
        String passwrd = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwrd);
        repo.save(user);
    }
}
