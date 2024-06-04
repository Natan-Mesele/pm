package com.example.project.pmsb.service;

import com.example.project.pmsb.model.Comment;

import java.util.List;

public interface CommentService {

    Comment createComment(Long issueId, Long userId, String comment) throws Exception;
    void deleteComment(Long commentId, Long userId) throws Exception;
    List<Comment> findCommentByIssue(Long issueId);
}
