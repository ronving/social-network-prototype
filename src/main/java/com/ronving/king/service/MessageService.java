package com.ronving.king.service;

import com.ronving.king.domain.Message;
import com.ronving.king.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

public interface MessageService {
    Iterable<Message> findMessagesByFilter(String filter);
    void createNewMessage(MultipartFile file, Message message) throws IOException;
    Set<Message> findMessagesByUser(User user);
    void updateMessage(Message message, String text, String tag, MultipartFile file) throws IOException;
}
