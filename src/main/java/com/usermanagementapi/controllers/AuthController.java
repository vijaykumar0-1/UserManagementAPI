package com.usermanagementapi.controllers;

import com.usermanagementapi.dto.LoginRequest;
import com.usermanagementapi.security.JwtTokenProvider;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider){
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtTokenProvider.generateToken(userDetails);

        return ResponseEntity.ok(
                Map.of(
                        "message", "Login successful",
                        "token", token
                )
        );
}

    @GetMapping("/protected")
    public ResponseEntity<String> protectedEndpoint() {
        return ResponseEntity.ok("This is a protected endpoint!");
    }

}
