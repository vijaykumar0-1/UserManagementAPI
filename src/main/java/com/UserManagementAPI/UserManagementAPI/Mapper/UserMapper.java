package com.UserManagementAPI.UserManagementAPI.Mapper;

import com.UserManagementAPI.UserManagementAPI.model.User;

public class UserMapper {

    public static User toUser(String firstName, String lastName, String email, String age,String password) {
        return new User(firstName,lastName,email,age,password);
    }
}
