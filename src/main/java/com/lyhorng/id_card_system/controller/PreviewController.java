package com.lyhorng.id_card_system.controller;

import com.lyhorng.id_card_system.entity.Profile;
import com.lyhorng.id_card_system.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/preview")
public class PreviewController {

    private final ProfileService profileService;

    public PreviewController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}")
    public String previewCard(
            @PathVariable Long id,
            Model model) {

        Profile profile = profileService.getProfileById(id);

        model.addAttribute("profile", profile);

        return "preview";
    }
}