package net.hamzaouggadi.secure4j.web;

import lombok.AllArgsConstructor;
import net.hamzaouggadi.secure4j.entities.User;
import net.hamzaouggadi.secure4j.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/postById")
    public ResponseEntity<User> getUserById(@RequestParam Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok("User Saved !");
    }

    @DeleteMapping("/deleteUserById")
    public ResponseEntity<String> deleteUserById(@RequestParam Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok("User Deleted !");
    }
}
