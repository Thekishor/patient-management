package com.auth_service.ServiceImpl;

import com.auth_service.Dto.UserRequest;
import com.auth_service.Dto.UserResponse;
import com.auth_service.Exception.EmailAlreadyExistsException;
import com.auth_service.Model.User;
import com.auth_service.Repository.UserRepository;
import com.auth_service.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())){
            throw new EmailAlreadyExistsException("Email address already exists");
        }
        else {
            User user = modelMapper.map(userRequest, User.class);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User saveUser = userRepository.save(user);
            return modelMapper.map(saveUser, UserResponse.class);
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
