package com.usermanagementapi.service.impl;

import com.usermanagementapi.dto.UserDto;
import com.usermanagementapi.entity.User;
import com.usermanagementapi.repository.UserRepository;
import com.usermanagementapi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String registerUser(UserDto userDto) {

        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            return "User with this email already exists!";
        }

        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            return "Username already taken!";
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAge(userDto.getAge());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole("ROLE_USER");

        userRepository.save(user);

        return "User created successfully!";
    }

}
