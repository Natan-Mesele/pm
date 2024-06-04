package com.example.project.pmsb.repository;

import com.example.project.pmsb.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentByIssueId(Long issueId);
}
