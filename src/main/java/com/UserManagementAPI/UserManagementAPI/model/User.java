package com.UserManagementAPI.UserManagementAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String age;
}
