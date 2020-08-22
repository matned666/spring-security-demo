package com.example.demospringzdalne.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/app/status")
                .hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/index", "/", "/index/**")
                .hasAnyAuthority("ROLE_ADMIN" , "ROLE_USER")
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .loginProcessingUrl("/login-process")
//                .failureUrl("/login?error")
                .defaultSuccessUrl("/index");
//                .and()
//                .logout().logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user@test.pl")
                .password(passwordEncoder.encode("pass"))
                .roles("USER")
                .and()
                .withUser("admin@test.pl")
                .password(passwordEncoder.encode("pass"))
                .roles("ADMIN");

        auth.jdbcAuthentication()
                .usersByUsernameQuery("select u.login, u.password, 1 from login_user u where u.login = ?")
                .authoritiesByUsernameQuery("select u.login, u.role, 1 from login_user u where u.login = ?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }
}
