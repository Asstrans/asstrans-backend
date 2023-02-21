package com.asstrans.agremiados.services.impl;

import com.asstrans.agremiados.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var user =  this.userRepository.findByEmail(username);
        if(user == null){
            logger.error("User not found", username);
            throw  new UsernameNotFoundException("Email não encontrado!");
        }
        logger.info("User found", username);
        return user;
    }
}
