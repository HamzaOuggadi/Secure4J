package net.hamzaouggadi.secure4j.repositories;

import net.hamzaouggadi.secure4j.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
