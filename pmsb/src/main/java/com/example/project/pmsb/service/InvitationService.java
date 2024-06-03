package com.example.project.pmsb.service;

import com.example.project.pmsb.model.Invitation;
import jakarta.mail.MessagingException;

public interface InvitationService {

    public void sendInvitation(String email, Long projectId) throws MessagingException;
    public Invitation acceptInvitation(String token, Long userId) throws Exception;
    public String getTokenUserMail(String userEmail);
    void deleteToken(String token);
}
