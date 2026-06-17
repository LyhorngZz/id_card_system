package com.lyhorng.id_card_system.controller;

import com.lyhorng.id_card_system.entity.Template;
import com.lyhorng.id_card_system.service.TemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping
    public List<Template> getAllTemplates() {
        return templateService.getAllTemplates();
    }

    @PostMapping
    public Template createTemplate(@RequestBody Template template) {
        return templateService.saveTemplate(template);
    }
}