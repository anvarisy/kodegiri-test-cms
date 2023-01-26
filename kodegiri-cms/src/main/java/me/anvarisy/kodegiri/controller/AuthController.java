package me.anvarisy.kodegiri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import me.anvarisy.kodegiri.dto.AuthRequest;
import me.anvarisy.kodegiri.dto.AuthResponse;
import me.anvarisy.kodegiri.dto.Response;
import org.springframework.web.bind.annotation.RequestBody;
import me.anvarisy.kodegiri.service.JwtService;

@RestController
public class AuthController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public Response<AuthResponse> authenticateUser(@RequestBody AuthRequest req){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        if (authentication.isAuthenticated()) {
            return new Response<AuthResponse>(true,
        200,
        "Authentication complete",
        new AuthResponse(jwtService.generateToken(req.getUsername())));
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
        
    }
}
