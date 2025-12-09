package com.usermanagementapi.service;

import com.usermanagementapi.dto.UserDto;

public interface UserService {
    String registerUser(UserDto userDto);
}
