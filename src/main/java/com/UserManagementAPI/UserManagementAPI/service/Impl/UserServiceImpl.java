package com.UserManagementAPI.UserManagementAPI.service.Impl;

import com.UserManagementAPI.UserManagementAPI.Mapper.UserMapper;
import com.UserManagementAPI.UserManagementAPI.model.User;
import com.UserManagementAPI.UserManagementAPI.repository.UserRepository;
import com.UserManagementAPI.UserManagementAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public String createUser(String firstName, String lastName, String email, String age) {
        User user = UserMapper.toUser(firstName,lastName,email,age);
        userRepository.createUser(user);
        return "user Created";
    }
}
