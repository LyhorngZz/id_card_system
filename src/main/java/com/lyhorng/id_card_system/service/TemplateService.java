package com.lyhorng.id_card_system.service;

import com.lyhorng.id_card_system.entity.Template;
import com.lyhorng.id_card_system.repository.TemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {

    private final TemplateRepository templateRepository;

    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public List<Template> getAllTemplates() {
        return templateRepository.findAll();
    }

    public Template saveTemplate(Template template) {
        return templateRepository.save(template);
    }
}