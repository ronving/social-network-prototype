package com.ronving.king.controller;

import com.ronving.king.domain.Message;
import com.ronving.king.domain.User;
import com.ronving.king.repos.MessageRepo;
import com.ronving.king.repos.UserRepo;
import com.ronving.king.service.AuthService;
import com.ronving.king.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final AuthService authService;
    private final MessageService messageService;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false) String filter, Model model) {
        Iterable<Message> messages = messageService.findMessagesByFilter(filter);
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text,
                      @RequestParam String tag, Map<String, Object> model,
                      @RequestParam("file") MultipartFile file) throws IOException {
        User user = authService.getAuthenticationPrincipal();
        Message message = new Message(text, tag, user);
        Iterable<Message> messages = messageService.createNewMessage(file, message);
        model.put("messages", messages);

        return "main";
    }
}
