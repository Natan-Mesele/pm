package com.example.project.pmsb.service;

import com.example.project.pmsb.model.Issue;
import com.example.project.pmsb.model.User;
import com.example.project.pmsb.request.IssueRequest;

import java.util.List;
import java.util.Optional;

public interface IssueService {

    Issue getIssueById(Long issueId) throws Exception;
    List<Issue> getIssueByProjectId(Long projectId) throws Exception;
    Issue createIssue(IssueRequest issue, User user) throws Exception;
    void deleteIssue(Long issueId, Long userid) throws Exception;
    Issue addUserToIssue(Long issueId, Long userId) throws Exception;
    Issue updateStatus(Long issueId, String status) throws Exception;
}
