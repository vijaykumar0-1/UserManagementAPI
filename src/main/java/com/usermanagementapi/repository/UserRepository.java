package com.usermanagementapi.repository;

import com.usermanagementapi.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

    User findByUsername(String username);
}
