package net.hamzaouggadi.secure4j.web;

import lombok.AllArgsConstructor;
import net.hamzaouggadi.secure4j.entities.Comment;
import net.hamzaouggadi.secure4j.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> listComments() {
        return ResponseEntity.ok(commentService.getComments());
    }

    @GetMapping("/getCommentById")
    public ResponseEntity<Comment> getCommentById(@RequestParam Long commentId) {
        return ResponseEntity.ok(commentService.getCommentById(commentId));
    }

    @PostMapping("/addComment")
    public ResponseEntity<String> addComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return ResponseEntity.ok("Comment Added !");
    }

    @DeleteMapping("/deleteCommentById")
    public ResponseEntity<String> deleteCommentById(@RequestParam Long commentId) {
        commentService.deleteCommentById(commentId);
        return ResponseEntity.ok("Comment Deleted !");
    }
}
