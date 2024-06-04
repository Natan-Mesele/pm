package com.example.project.pmsb.service;

import com.example.project.pmsb.model.Comment;
import com.example.project.pmsb.model.Issue;
import com.example.project.pmsb.model.User;
import com.example.project.pmsb.repository.CommentRepository;
import com.example.project.pmsb.repository.IssueRepository;
import com.example.project.pmsb.repository.UserRepository;
import org.hibernate.annotations.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Comment createComment(Long issueId, Long userId, String content) throws Exception {
        Optional<Issue> issueOptional = issueRepository.findById(issueId);
        Optional<User> userOptional = userRepository.findById(userId);

        if(issueOptional.isEmpty()){
            throw new Exception("issue not found with id"+issueId);
        }
        if(userOptional.isEmpty()){
            throw new Exception("user not found with id" + userId);
        }
        Issue issue = issueOptional.get();
        User user = userOptional.get();

        Comment comment = new Comment();

        comment.setIssue(issue);
        comment.setUser(user);
        comment.setCreatedDateTime(LocalDateTime.now());
        comment.setContent(content);

        Comment savedComment = commentRepository.save(comment);

        issue.getComments().add((Comments) savedComment);
        return savedComment;
    }

    @Override
    public void deleteComment(Long commentId, Long userId) throws Exception {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        Optional<User> userOptional = userRepository.findById(userId);

        if(commentOptional.isEmpty()){
            throw new Exception("Comment not found with id"+commentId);
        }
        if(userOptional.isEmpty()){
            throw new Exception("user not found with id"+userId);
        }

        Comment comment = commentOptional.get();
        User user = userOptional.get();

        if(comment.getUser().equals(user)){
            commentRepository.delete(comment);
        }else {
            throw new Exception("user does not have permission to delete this comment");
        }
    }

    @Override
    public List<Comment> findCommentByIssue(Long issueId) {
        return commentRepository.findCommentByIssueId(issueId);
    }
}
