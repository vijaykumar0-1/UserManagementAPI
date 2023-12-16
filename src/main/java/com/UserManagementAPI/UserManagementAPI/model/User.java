package com.UserManagementAPI.UserManagementAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "User")
public class User {
    private String firstName;
    private String lastName;
    @Id
    private String email;
    private String  age;
    private String password;

}
