package com.ronving.king.controller;

import com.ronving.king.domain.Message;
import com.ronving.king.domain.User;
import com.ronving.king.service.AuthService;
import com.ronving.king.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

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
    public String add(@Valid Message message,
                      BindingResult bindingResult,
                      Model model,
                      @RequestParam("file") MultipartFile file) throws IOException {
        Iterable<Message> messages;
        User user = authService.getAuthenticationPrincipal();
        message.setAuthor(user);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errors);
            model.addAttribute("message", message);
            messages = messageService.findMessagesByFilter(null);
        }
        else {
            messageService.createNewMessage(file, message);
            messages = messageService.findMessagesByFilter("");
            model.addAttribute("message", null);
        }

        model.addAttribute("messages", messages);
        return "main";
    }
}
