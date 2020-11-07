package com.ronving.king.service;

import com.ronving.king.domain.Message;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MessageService {
    Iterable<Message> findMessagesByFilter(String filter);
    Iterable<Message> createNewMessage(MultipartFile file, Message message) throws IOException;
}
