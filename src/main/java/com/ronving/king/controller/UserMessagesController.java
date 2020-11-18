package com.ronving.king.controller;

import com.ronving.king.domain.Message;
import com.ronving.king.domain.User;
import com.ronving.king.service.AuthService;
import com.ronving.king.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Set;

@Controller
@RequestMapping("/user-messages")
@RequiredArgsConstructor
public class UserMessagesController {
    private final MessageService messageService;
    private final AuthService authService;

    @GetMapping("/{user}")
    public String userMessages(@PathVariable User user, Model model,
                               @RequestParam(required = false) Message message) {
        Set<Message> userMessages = messageService.findMessagesByUser(user);
        boolean isCurrentUser = authService.isCurrentUser(user);

        model.addAttribute("message", message);
        model.addAttribute("messages", userMessages);
        model.addAttribute("isCurrentUser", isCurrentUser);
        return "userMessages";
    }

    @PostMapping("/{user}")
    public String updateMessage(@PathVariable User user, @Valid @RequestParam("id")  Message message,
                                @RequestParam("text") String text,
                                @RequestParam("tag") String tag,
                                @RequestParam("file") MultipartFile file
                                ) throws IOException {
        boolean isCurrentUser = authService.isCurrentUser(user);
        if (isCurrentUser) {
            messageService.updateMessage(message, text, tag, file);
        }
        return "redirect:/user-messages/" + user.getId();
    }
}
