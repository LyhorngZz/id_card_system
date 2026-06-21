package com.lyhorng.id_card_system.controller;

import com.lyhorng.id_card_system.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final ProfileService profileService;

    public ViewController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/")
    public String dashboard(Model model) {

        model.addAttribute(
                "profiles",
                profileService.getAllProfiles());

        return "dashboard";
    }

    @GetMapping("/profiles/new")
    public String newProfile() {
        return "profile-form";
    }
}