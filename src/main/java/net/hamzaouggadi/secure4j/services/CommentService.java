package net.hamzaouggadi.secure4j.services;

import net.hamzaouggadi.secure4j.entities.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getComments();
    Comment getCommentById(Long commentId);
    void addComment(Comment comment);
    void deleteCommentById(Long commentId);
}
