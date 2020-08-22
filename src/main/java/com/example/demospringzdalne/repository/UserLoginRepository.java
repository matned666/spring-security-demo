package com.example.demospringzdalne.repository;

import com.example.demospringzdalne.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<LoginUser, Long> {
}
