package net.hamzaouggadi.secure4j.services.implementations;

import lombok.AllArgsConstructor;
import net.hamzaouggadi.secure4j.dtos.UserDTO;
import net.hamzaouggadi.secure4j.entities.AuthenticationRequest;
import net.hamzaouggadi.secure4j.entities.AuthenticationResponse;
import net.hamzaouggadi.secure4j.repositories.UserRepository;
import net.hamzaouggadi.secure4j.services.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    @Override
    public void registerUser(UserDTO userDTO) {

    }

    @Override
    public AuthenticationResponse authentication(AuthenticationRequest authenticationRequest) {
        return null;
    }
}
