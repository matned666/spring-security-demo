package com.example.demospringzdalne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

//    @Autowired
//    PasswordEncoder passwordEncoder;
    @Autowired
    PasswordEncoder passwordEncoderMD5;
//    @Autowired
//    PasswordEncoder passwordEncoderSha256;
//    @Autowired
//    PasswordEncoder passwordEncoderBCrypt;

    @GetMapping("/app/v2/status")
    public String getStatus2() {
        return "status2: healthy";
    }

    @GetMapping("/app/status")
    public  String getStatusInfo() {

        String salt = "123$%#@#@Sald$%453222";
//        System.out.println("NOOP: "+passwordEncoder.encode("pass")); // pass
        System.out.println("MD5: "+passwordEncoderMD5.encode("pass")); // MD5: {Uug537EEUsP33Vqnd5O2w29RZQvyuSEBlgZNXY+P78k=}051fc7933a58cb721d9e440172eba442
//        System.out.println("SHA-256: "+passwordEncoderSha256.encode("pass")); // SHA-256: {dYfgjTO4YVbPJVSkX/z4NqigLhlhYsqXPlFsE4/xlSg=}bacfd6d2c6c60c267c9c1c89596fc51811f6762ef04e05b1e7d742e1c8505520
//        System.out.println("BCrypt: "+passwordEncoderBCrypt.encode("pass"));  //BCrypt: $2a$10$73IeGjnwcFmojkwFaGd19.x9AxziHN1S/wdo0kpQqzF5mFY66CP/y


        return "Status:healthy";
    }
}
