package com.example.demospringzdalne.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }

//@Bean
//    public PasswordEncoder passwordEncoderMD5(){
//        return new MessageDigestPasswordEncoder("MD5");
//    }

//    @Bean
//    public PasswordEncoder passwordEncoderSha256(){
//        return new MessageDigestPasswordEncoder("SHA-256");
//    }
//


    @Bean
    public PasswordEncoder passwordEncoderBCrypt(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/user_app?serverTimezone=Europe/Warsaw");
        dataSource.setUsername("root");
//        dataSource.setPassword("password");
        return dataSource;
    }

}
