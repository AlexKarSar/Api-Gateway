package com.example.apigateway.controller.interfaces;

import com.example.apigateway.dto.request.JwtRequest;
import com.example.apigateway.dto.request.RefreshRequest;
import com.example.apigateway.dto.request.RegistrationRequest;
import com.example.apigateway.dto.request.SignOutRequest;
import org.springframework.http.ResponseEntity;

public interface UserInterface {

    ResponseEntity<?> registration (RegistrationRequest request);

    ResponseEntity<?> authorisation (JwtRequest request);

    ResponseEntity<?> refreshTokens (RefreshRequest request);

    void signOut (SignOutRequest request);

}
