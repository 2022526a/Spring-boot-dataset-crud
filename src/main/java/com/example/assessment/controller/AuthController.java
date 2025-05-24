package com.example.assessment.controller;

import com.example.assessment.model.CovidCase;
import com.example.assessment.repository.CovidCaseRepository;
import com.example.assessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public String welcome(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        // Add page sizes list to model
        model.addAttribute("pageSizes", List.of(5, 10, 20, 50));

        Page<CovidCase> casesPage = covidCaseRepository.findAll(
                PageRequest.of(page, size, Sort.by("reportDate").descending()));

        model.addAttribute("cases", casesPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("totalPages", casesPage.getTotalPages());
        model.addAttribute("totalItems", casesPage.getTotalElements());

        return "welcome";
    }
}