package com.asstrans.agremiados.controllers;

import com.asstrans.agremiados.dto.UpdatePassDto;
import com.asstrans.agremiados.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @PutMapping("/pass")
    public ResponseEntity<Void> delete(@RequestBody UpdatePassDto updatePassDto) {
        userService.updatePassword(updatePassDto);
        return ResponseEntity.noContent().build();
    }
}
