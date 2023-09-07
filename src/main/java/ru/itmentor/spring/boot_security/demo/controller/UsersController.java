package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmentor.spring.boot_security.demo.Models.User;
import ru.itmentor.spring.boot_security.demo.Service.UserServiceImp;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UsersController {
    private final UserServiceImp userService;

    @Autowired
    public UsersController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUserById(Model model, Principal principal) {
        User user = (User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "users/UsersShow";
    }
}
