package com.example.project.pmsb.service;

import com.example.project.pmsb.model.Chat;
import com.example.project.pmsb.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Chat createChat(Chat chat) {
        return null;
    }
}
