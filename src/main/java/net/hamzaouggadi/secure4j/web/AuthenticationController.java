package net.hamzaouggadi.secure4j.web;

import lombok.AllArgsConstructor;
import net.hamzaouggadi.secure4j.services.AuthenticationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

}
