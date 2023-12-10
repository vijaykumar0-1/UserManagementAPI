package com.UserManagementAPI.UserManagementAPI.controller;

import com.UserManagementAPI.UserManagementAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(path = "user/register")
    public ResponseEntity<?> userRegistration(@RequestParam String firstName,
                                              @RequestParam String lastName,
                                              @RequestParam String email,
                                              @RequestParam String age)
    {
        String response =  userService.createUser(firstName,lastName,email,age);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
