package net.hamzaouggadi.secure4j.web;

import lombok.AllArgsConstructor;
import net.hamzaouggadi.secure4j.entities.Post;
import net.hamzaouggadi.secure4j.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping()
    public ResponseEntity<List<Post>> listPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }

    @GetMapping("/postById")
    public ResponseEntity<Post> getPostById(@RequestParam Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @PostMapping("/addPost")
    public ResponseEntity<String> addPost(@RequestBody Post post) {
        postService.addPost(post);
        return ResponseEntity.ok("Post Saved !");
    }


    @DeleteMapping("/deletePostById")
    public ResponseEntity<String> deletePostById(@RequestParam Long postId) {
        postService.deletePostById(postId);
        return ResponseEntity.ok("Post Deleted !");
    }
}
