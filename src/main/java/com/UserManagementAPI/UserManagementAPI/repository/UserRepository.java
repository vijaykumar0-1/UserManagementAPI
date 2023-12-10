package com.UserManagementAPI.UserManagementAPI.repository;

import com.UserManagementAPI.UserManagementAPI.model.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private MongoTemplate mongoTemplate;

    public void createUser(User user) {
    }
}
