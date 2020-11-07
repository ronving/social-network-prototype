package com.ronving.king.controller;

import com.ronving.king.domain.Role;
import com.ronving.king.domain.User;
import com.ronving.king.service.AuthService;
import com.ronving.king.service.MailSenderService;
import com.ronving.king.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final AuthService authService;
    private final UserService userService;
    private final MailSenderService mailSenderService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String getUserList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String editUser(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String saveUser(@RequestParam String username,
                           @RequestParam("userId") User user,
                           @RequestParam Map<String, String> form) {
        userService.saveUser(user, username, form);
        return "redirect:/user";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("delete/{user}")
    public String deleteUser(@PathVariable User user) {
        userService.deleteUser(user);
        return "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(Model model) {
        User user = authService.getAuthenticationPrincipal();
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(@RequestParam String password, @RequestParam String email) {
        User user = authService.getAuthenticationPrincipal();
        User updatedUser = userService.updateProfile(user, password, email);

        if (!updatedUser.getActivationCode().equals(user.getActivationCode())) {
            mailSenderService.createActivationMessage(updatedUser);
        }
        return "redirect:/user/profile";
    }
}
