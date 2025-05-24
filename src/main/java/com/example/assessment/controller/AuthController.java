package com.example.assessment.controller;

import com.example.assessment.model.CovidCase;
import com.example.assessment.repository.CovidCaseRepository;
import com.example.assessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class AuthController {

    private final UserService userService;
    private final CovidCaseRepository covidCaseRepository;

    @Autowired
    public AuthController(UserService userService, CovidCaseRepository covidCaseRepository) {
        this.userService = userService;
        this.covidCaseRepository = covidCaseRepository;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        userService.registerUser(username, password);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        List<CovidCase> cases = covidCaseRepository.findAllByOrderByReportDateDesc();
        model.addAttribute("cases", cases);
        return "welcome";
    }
}