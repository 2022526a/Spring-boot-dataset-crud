package com.example.assessment.controller;

import com.example.assessment.model.CovidCase;
import com.example.assessment.repository.CovidCaseRepository;
import com.example.assessment.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            Model model,
            CsrfToken csrfToken
    ) {

        model.addAttribute("pageSizes", List.of(5, 10, 20, 50));

        Page<CovidCase> casesPage = covidCaseRepository.findAll(
                PageRequest.of(page, size, Sort.by("reportDate").descending()));

        model.addAttribute("cases", casesPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("totalPages", casesPage.getTotalPages());
        model.addAttribute("totalItems", casesPage.getTotalElements());
        model.addAttribute("_csrf", csrfToken);

        return "welcome";
    }



    @GetMapping("/covid-cases/edit/{id}")
    @ResponseBody
    public CovidCase getCaseForEdit(@PathVariable Long id) {
        return covidCaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Case not found"));
    }

    @PostMapping("/covid-cases/update")
    public String updateCase(@ModelAttribute CovidCase updatedCase) {
        CovidCase existingCase = covidCaseRepository.findById(updatedCase.getId())
                .orElseThrow(() -> new RuntimeException("Case not found"));

        existingCase.setReportDate(updatedCase.getReportDate());
        existingCase.setCounty(updatedCase.getCounty());
        existingCase.setConfirmedCases(updatedCase.getConfirmedCases());
        existingCase.setHospitalizedCases(updatedCase.getHospitalizedCases());
        existingCase.setDeaths(updatedCase.getDeaths());

        covidCaseRepository.save(existingCase);
        return "redirect:/welcome";
    }


    @PostMapping("/covid-cases/add")
    public String addCovidCase(@Valid @ModelAttribute("covidCase") CovidCase covidCase,
                               BindingResult result,
                               RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            if (isAjaxRequest()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data");
            }
            return "add-covid-case";
        }

        covidCaseRepository.save(covidCase);
        redirectAttributes.addFlashAttribute("successMessage", "Case added successfully!");
        return "redirect:/welcome";
    }

    private boolean isAjaxRequest() {
        String requestedWith = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
                .getRequest()
                .getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(requestedWith);
    }
}