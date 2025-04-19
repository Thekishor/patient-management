package com.auth_service.Service;

import com.auth_service.Dto.UserRequest;
import com.auth_service.Dto.UserResponse;
import com.auth_service.Model.User;

import java.util.Optional;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);

    Optional<User> findByEmail(String email);
}
