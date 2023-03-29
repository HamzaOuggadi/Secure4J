package net.hamzaouggadi.secure4j.web;

import lombok.AllArgsConstructor;
import net.hamzaouggadi.secure4j.dtos.UserDTO;
import net.hamzaouggadi.secure4j.entities.AuthenticationRequest;
import net.hamzaouggadi.secure4j.entities.AuthenticationResponse;
import net.hamzaouggadi.secure4j.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(authenticationService.registerUser(userDTO));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authentication(authenticationRequest));
    }

}
