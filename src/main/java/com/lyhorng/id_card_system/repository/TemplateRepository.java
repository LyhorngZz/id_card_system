package com.lyhorng.id_card_system.repository;

import com.lyhorng.id_card_system.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<Template, Long> {

    boolean existsByName(String name);
}