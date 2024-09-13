package com.bistrocontrol.bistro_control.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bistrocontrol.bistro_control.model.RegisterUserForm;
import com.bistrocontrol.bistro_control.repository.UserRepository;
import com.bistrocontrol.bistro_control.service.UserService;

import jakarta.validation.Valid;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/cadastro")
    public String showRegisterPage(RegisterUserForm registerUserForm) {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String postUser(@Valid RegisterUserForm registerUserForm, 
    BindingResult result, Model model) {
        if(result.hasErrors()) {
            System.out.println("Informações preenchidas são inválidas.");
            System.out.println("Erros: " );
            for(FieldError error: result.getFieldErrors()) {
                System.out.println("Erro: " + error);
            }
            return "/cadastro";
        }
        if (userRepository.findByEmail(registerUserForm.email()).isPresent()) {
            result.rejectValue("email", "error.registerUserForm", "An account already exists for this email.");
            System.out.println("Passou por aqui.");
            return "/cadastro";
        }
        userService.register(registerUserForm);
        model.addAttribute("success", "Conta criada com sucesso. Você ja pode logar.");

        return "/cadastro"; 
    }

    @GetMapping("/admin")
    public String showAdminPage() {
        return "admin";
    }

    @GetMapping("/cliente")
    public String showClienteMainPage() {
        return "cliente";
    }

    @GetMapping("/redirect")
    public String redirectToMain() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication.getAuthorities().stream()
        .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin";
        }

        if (authentication.getAuthorities().stream()
        .anyMatch(r -> r.getAuthority().equals("ROLE_USER"))) {
            return "redirect:/cliente";
        }

        return "redirect:/login";
    }
}
