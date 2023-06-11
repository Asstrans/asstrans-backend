package com.asstrans.agremiados.services.impl;

import com.asstrans.agremiados.dto.UpdatePassDto;
import com.asstrans.agremiados.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

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

    @Transactional
    public void updatePassword(UpdatePassDto updatePassDto){
        var email = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            email = ((UserDetails)principal).getUsername();
        }
        var user = userRepository.findByEmail(email);
        var newPass = encoder.encode(updatePassDto.pass());
        user.setPassword(newPass);
    }
}
