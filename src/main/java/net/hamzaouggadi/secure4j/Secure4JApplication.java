package net.hamzaouggadi.secure4j;

import com.github.javafaker.Faker;
import net.hamzaouggadi.secure4j.entities.Comment;
import net.hamzaouggadi.secure4j.entities.Post;
import net.hamzaouggadi.secure4j.entities.User;
import net.hamzaouggadi.secure4j.repositories.CommentRepository;
import net.hamzaouggadi.secure4j.repositories.PostRepository;
import net.hamzaouggadi.secure4j.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class Secure4JApplication {

    public static void main(String[] args) {
        SpringApplication.run(Secure4JApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PostRepository postRepository,
                            CommentRepository commentRepository,
                            UserRepository userRepository) {
        return args -> {
            Faker faker = new Faker();
            Random random = new Random();
            int min = 1;
            int max = 5;
            int max2 = 3;

            Stream.of("Hamza", "Marie", "7med").forEach(usr -> {
                User user = User.builder()
                        .fullName(usr)
                        .email(usr + "@gmail.com")
                        .password("hamza123")
                        .build();
                userRepository.save(user);
            });

            for (int i=0; i<5; i++) {
                Post post = Post.builder()
                        .title(faker.lorem().sentence(1))
                        .content(faker.lorem().paragraph(40))
                        .user(userRepository.findById((long)random.nextInt(max2 - min + 1) + min).orElseThrow())
                        .build();
                postRepository.save(post);
            }

            for (int i=0; i<5; i++) {
                Comment comment = Comment.builder()
                        .comment(faker.lorem().paragraph(2))
                        .post(postRepository.findById((long)random.nextInt(max - min + 1) + min).orElseThrow())
                        .user(userRepository.findById((long)random.nextInt(max2 - min + 1) + min).orElseThrow())
                        .build();
                commentRepository.save(comment);
            }
        };
    }

}
