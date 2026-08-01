package com.project.snakeandladder.services;

import com.project.snakeandladder.config.JwtUtil;
import com.project.snakeandladder.dtos.LoginRequestDto;
import com.project.snakeandladder.entities.User;
import com.project.snakeandladder.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final Logger log = LoggerFactory.getLogger(AuthService.class);

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    public AuthService(UserRepository userRepository,  AuthenticationManager authenticationManager,  JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }


    public String login(LoginRequestDto loginRequestDto){

        String username = loginRequestDto.getUsername();
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username)
        );

        log.info("got the user "+user.getUsername());

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, loginRequestDto.getPassword()));

        log.info("got the user authenticated");
        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        return jwtUtil.generateJwtToken(userDetails);
    }
}
