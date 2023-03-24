package net.hamzaouggadi.secure4j.services;

import net.hamzaouggadi.secure4j.entities.Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts();
    Post getPostById(Long postId);
    void addPost(Post post);
    void deletePostById(Long postId);
}
