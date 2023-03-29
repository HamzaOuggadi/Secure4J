package net.hamzaouggadi.secure4j.services.implementations;

import lombok.AllArgsConstructor;
import net.hamzaouggadi.secure4j.config.JwtService;
import net.hamzaouggadi.secure4j.dtos.UserDTO;
import net.hamzaouggadi.secure4j.entities.AuthenticationRequest;
import net.hamzaouggadi.secure4j.entities.AuthenticationResponse;
import net.hamzaouggadi.secure4j.entities.Role;
import net.hamzaouggadi.secure4j.entities.User;
import net.hamzaouggadi.secure4j.repositories.UserRepository;
import net.hamzaouggadi.secure4j.services.AuthenticationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponse registerUser(UserDTO userDTO) {
        User user = User.builder()
                .fullName(userDTO.getFullName())
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authentication(AuthenticationRequest authenticationRequest) {
        return null;
    }
}
