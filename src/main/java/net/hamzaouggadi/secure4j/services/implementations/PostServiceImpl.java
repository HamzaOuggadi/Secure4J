package net.hamzaouggadi.secure4j.services.implementations;

import lombok.AllArgsConstructor;
import net.hamzaouggadi.secure4j.entities.Post;
import net.hamzaouggadi.secure4j.repositories.PostRepository;
import net.hamzaouggadi.secure4j.services.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElseThrow();
    }

    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}
