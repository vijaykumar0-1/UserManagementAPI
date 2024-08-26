package com.UserManagementAPI.UserManagementAPI.controllers;

import com.UserManagementAPI.UserManagementAPI.dto.UserDto;
import com.UserManagementAPI.UserManagementAPI.service.UserService;
import com.UserManagementAPI.UserManagementAPI.utils.JwtTokenUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    // Normal login controller
    @PostMapping(value = "v1/userLogin")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody UserDto user) {
        String response = userService.userLogin(user);


        Map<String, String> responseBody = new HashMap<>();
//         responseBody.put("message","sls");
//         return new ResponseEntity<>(responseBody, HttpStatus.OK);

        if (response.equals("Login successful !")) {
            // Generate the JWT token

            String token = jwtTokenUtil.generateToken(user.getEmail()); // Ensure you have a method to generate the token

            responseBody.put("message", response);
            responseBody.put("token", token); // Include the token in the response
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        } else {
            responseBody.put("message", response);
            return new ResponseEntity<>(responseBody, HttpStatus.UNAUTHORIZED); // Return 401 for unauthorized access
        }

}

    @GetMapping("/protected")
    public ResponseEntity<String> protectedEndpoint() {
        return ResponseEntity.ok("This is a protected endpoint!");
    }

}
