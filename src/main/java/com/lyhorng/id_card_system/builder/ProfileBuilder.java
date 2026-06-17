package com.lyhorng.id_card_system.builder;

import com.lyhorng.id_card_system.entity.Profile;
import com.lyhorng.id_card_system.enums.BarcodeType;
import com.lyhorng.id_card_system.enums.ProfileType;

import java.time.LocalDate;

public class ProfileBuilder {

    public static Profile createDefaultStudent() {

        return Profile.builder()
                .type(ProfileType.STUDENT)
                .fullName("New Student")
                .department("IT")
                .title("Student")
                .barcodeType(BarcodeType.CODE_128)
                .issueDate(LocalDate.now())
                .expiryDate(LocalDate.now().plusYears(4))
                .build();
    }
}