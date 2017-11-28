package com.example.controller;

import com.example.form.AccountForm;
import com.example.validator.EmailCorrelationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/register")
@Controller
public class AccountController {

    private EmailCorrelationValidator emailCorrelationValidator;

    @Autowired
    public AccountController(EmailCorrelationValidator emailCorrelationValidator) {
        this.emailCorrelationValidator = emailCorrelationValidator;
    }



    @InitBinder
    public void initBinder(final WebDataBinder webDataBinder) {
        webDataBinder.addValidators(emailCorrelationValidator);
    }

    @GetMapping
    public String registerForm(final Model model) {
        model.addAttribute("registerForm", new AccountForm());
        return "form";
    }

    @PostMapping
    public String register(@Valid @ModelAttribute("registerForm") final AccountForm accountForm, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        return "redirect:/results";
    }
}
