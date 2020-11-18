package com.ronving.king.service.impl;

import com.ronving.king.domain.Message;
import com.ronving.king.domain.User;
import com.ronving.king.repos.MessageRepo;
import com.ronving.king.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepo messageRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public Iterable<Message> findMessagesByFilter(String filter) {
        if (filter != null && !filter.isEmpty()) {
            return messageRepo.findByTag(filter);
        } else {
            return messageRepo.findAll();
        }
    }

    @Override
    public void createNewMessage(MultipartFile file, Message message) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            message.setFilename(resultFilename);
        }

        messageRepo.save(message);
    }

    @Override
    public Set<Message> findMessagesByUser(User user) {
        return user.getMessages();
    }

    @Override
    public void updateMessage(Message message, String text, String tag, MultipartFile file) throws IOException {
        if (!StringUtils.isEmpty(text)) {
            message.setText(text);
        }
        if (!StringUtils.isEmpty(tag)) {
            message.setTag(tag);
        }

        createNewMessage(file, message);
    }

}
