package com.example.project.pmsb.controller;

import com.example.project.pmsb.model.Chat;
import com.example.project.pmsb.model.Message;
import com.example.project.pmsb.model.User;
import com.example.project.pmsb.request.CreateMessageRequest;
import com.example.project.pmsb.service.MessageService;
import com.example.project.pmsb.service.ProjectService;
import com.example.project.pmsb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody CreateMessageRequest request)
        throws Exception{
        User user = userService.findUserById(request.getSenderId());

        Chat chats = projectService.getProjectById(request.getProjectId()).getChat();
        if(chats==null) throw new Exception("Chats not found");
        Message sentMessage = messageService.sendMessage(request.getSenderId(),
                request.getProjectId(), request.getContent());
        return ResponseEntity.ok(sentMessage);

    }

    @GetMapping("/chat/{projectId}")
    public ResponseEntity<List<Message>> getMessageByChatId(@PathVariable Long projectId)
        throws Exception{
        List<Message> messages = messageService.getMessageByProjectId(projectId);
        return ResponseEntity.ok(messages);
    }
}
