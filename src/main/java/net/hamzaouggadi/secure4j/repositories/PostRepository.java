package net.hamzaouggadi.secure4j.repositories;

import net.hamzaouggadi.secure4j.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
