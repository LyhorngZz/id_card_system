package com.lyhorng.id_card_system.entity;

import com.lyhorng.id_card_system.enums.BarcodeType;
import com.lyhorng.id_card_system.enums.ProfileType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    @Column(unique = true)
    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    private ProfileType type;

    private String fullName;

    private String department;

    private String title;

    private String email;

    private String phone;

    private String bloodGroup;

    private LocalDate dateOfBirth;

    private LocalDate issueDate;

    private LocalDate expiryDate;

    private String photoFileName;

    private String photoContentType;

    @Enumerated(EnumType.STRING)
    private BarcodeType barcodeType;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private Template template;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
        }

        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}