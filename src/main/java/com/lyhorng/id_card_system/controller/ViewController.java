package com.lyhorng.id_card_system.controller;

import com.lyhorng.id_card_system.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lyhorng.id_card_system.entity.Profile;

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
    public String newProfile(Model model) {

        model.addAttribute("profile", new Profile());

        return "profile-form";
    }

    @PostMapping("/profiles/save")
    public String saveProfile(@ModelAttribute Profile profile) {

        profileService.saveProfile(profile);

        return "redirect:http://152.42.254.59:8080/";
    }

    @GetMapping("/profiles/{id}/card")
    public String viewCard(
            @PathVariable Long id,
            Model model) {

        Profile profile =
                profileService.getProfileById(id);

        model.addAttribute("profile", profile);

        return "profile-card";
    }
}