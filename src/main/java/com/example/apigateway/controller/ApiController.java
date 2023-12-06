package com.example.apigateway.controller;


import com.example.apigateway.config.TokenFilter;
import com.example.apigateway.controller.interfaces.UserInterface;
import com.example.apigateway.dto.request.JwtRequest;
import com.example.apigateway.dto.request.RefreshRequest;
import com.example.apigateway.dto.request.RegistrationRequest;
import com.example.apigateway.dto.request.SignOutRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController implements UserInterface {

    @Autowired
    private TokenFilter filter;

    @PostMapping("/register")
    public ResponseEntity<?> registration(@RequestBody RegistrationRequest request) {
        RestTemplate cl = new RestTemplate();
        return ResponseEntity.ok(cl.postForEntity("http://localhost:8085/register", request, String.class).getBody());
    }

    @PostMapping("/auth")
    public ResponseEntity<?> authorisation(@RequestBody JwtRequest request) {
        return ResponseEntity.ok(new RestTemplate().postForEntity("http://localhost:8085/auth", request, String.class).getBody());
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshTokens(@RequestBody RefreshRequest request) {
        return ResponseEntity.ok(new RestTemplate().postForEntity("http://localhost:8085/refresh", request, String.class).getBody());
    }

    @PostMapping("/signout")
    public void signOut(@RequestBody SignOutRequest request) {
        ResponseEntity.ok(new RestTemplate().postForEntity("http://localhost:8085/signout", request, String.class).getBody());
    }
}
