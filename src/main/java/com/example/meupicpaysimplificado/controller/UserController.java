package com.example.meupicpaysimplificado.controller;

import com.example.meupicpaysimplificado.domain.UserDto;
import com.example.meupicpaysimplificado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    private ResponseEntity<UserDto> createUser(@RequestBody UserDto dto){
        UserDto userDto = service.createUser(dto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<UserDto>> findALl(){
        List<UserDto> userDto = service.findAll();
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
