package com.example.service;

import com.example.dto.UserDto;
import com.example.request.AuthenticationRequest;

public interface AuthenticationService {
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
