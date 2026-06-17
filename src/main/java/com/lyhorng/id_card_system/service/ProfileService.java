package com.lyhorng.id_card_system.service;

import com.lyhorng.id_card_system.entity.Profile;
import com.lyhorng.id_card_system.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile saveProfile(Profile profile) {

        if (profile.getRegistrationNumber() == null
                || profile.getRegistrationNumber().isBlank()) {

            profile.setRegistrationNumber(
                    generateRegistrationNumber(profile.getDepartment()));
        }

        return profileRepository.save(profile);
    }

    public Profile getProfileById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    public Profile updateProfile(Long id, Profile updatedProfile) {

        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        profile.setRegistrationNumber(updatedProfile.getRegistrationNumber());
        profile.setType(updatedProfile.getType());
        profile.setFullName(updatedProfile.getFullName());
        profile.setDepartment(updatedProfile.getDepartment());
        profile.setTitle(updatedProfile.getTitle());
        profile.setEmail(updatedProfile.getEmail());
        profile.setPhone(updatedProfile.getPhone());
        profile.setBloodGroup(updatedProfile.getBloodGroup());
        profile.setDateOfBirth(updatedProfile.getDateOfBirth());
        profile.setIssueDate(updatedProfile.getIssueDate());
        profile.setExpiryDate(updatedProfile.getExpiryDate());
        profile.setPhotoFileName(updatedProfile.getPhotoFileName());
        profile.setPhotoContentType(updatedProfile.getPhotoContentType());
        profile.setBarcodeType(updatedProfile.getBarcodeType());
        profile.setTemplate(updatedProfile.getTemplate());

        return profileRepository.save(profile);
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }

    private String generateRegistrationNumber(String department) {

        long count = profileRepository.count() + 1;

        return String.format(
                "%d-%s-%03d",
                java.time.Year.now().getValue(),
                department.toUpperCase(),
                count);
    }

    public List<Profile> saveAllProfiles(List<Profile> profiles) {

        profiles.forEach(profile -> {

            if (profile.getRegistrationNumber() == null
                    || profile.getRegistrationNumber().isBlank()) {

                profile.setRegistrationNumber(
                        generateRegistrationNumber(profile.getDepartment()));
            }
        });

        return profileRepository.saveAll(profiles);
    }
}