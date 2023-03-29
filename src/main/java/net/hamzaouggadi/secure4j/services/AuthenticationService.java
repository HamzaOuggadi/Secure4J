package net.hamzaouggadi.secure4j.services;

import net.hamzaouggadi.secure4j.dtos.UserDTO;
import net.hamzaouggadi.secure4j.entities.AuthenticationRequest;
import net.hamzaouggadi.secure4j.entities.AuthenticationResponse;

public interface AuthenticationService {

    void registerUser(UserDTO userDTO);
    AuthenticationResponse authentication(AuthenticationRequest authenticationRequest);

}
