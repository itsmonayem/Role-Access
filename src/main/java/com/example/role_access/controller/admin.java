package com.example.role_access.controller;

import com.example.role_access.entity.User;
import com.example.role_access.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin/")
public class admin {
    private final UserRepository userRepository;

    public admin(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        User user = this.userRepository.getUserByUserName(principal.getName());

        List<User> users = this.userRepository.findAll();
        model.addAttribute("userList",users);
        model.addAttribute("user_name",user.getName());
        model.addAttribute("user_type",user.getRole());
        return "Admin/home";
    }

    @PostMapping("/change-to/")
    public String change_role(@RequestParam String email, @RequestParam String role) {
        System.out.println(role);
        User user = this.userRepository.getUserByUserName(email);
        user.setRole(role);
        this.userRepository.save(user);
        return "redirect:/admin/";
    }
}
