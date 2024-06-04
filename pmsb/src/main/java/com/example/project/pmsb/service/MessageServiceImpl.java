package com.example.project.pmsb.service;

import com.example.project.pmsb.model.Chat;
import com.example.project.pmsb.model.Message;
import com.example.project.pmsb.model.User;
import com.example.project.pmsb.repository.MessageRepository;
import com.example.project.pmsb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectService projectService;

    @Override
    public List<Message> getMessageByProjectId(Long projectId) throws Exception {
        return List.of();
    }

    @Override
    public Message sendMessage(Long senderId, Long projectId, String content) throws Exception {
        User sender = userRepository.findById(senderId)
                .orElseThrow(()-> new Exception("user not found with id: "+senderId));

        Chat chat = projectService.getProjectById(projectId).getChat();

        Message message = new Message();
        message.setContent(content);
        message.setSender(sender);
        message.setCreatedAt(LocalDateTime.now());
        message.setChat(chat);
        Message savedMessage = messageRepository.save(message);

        chat.getMessages().add(savedMessage);

        return savedMessage;

    }
}
