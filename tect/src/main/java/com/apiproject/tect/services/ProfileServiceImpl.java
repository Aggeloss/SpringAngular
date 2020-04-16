package com.apiproject.tect.services;

import com.apiproject.tect.entities.Profile;
import com.apiproject.tect.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Iterable<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile find(int id) {
        return profileRepository.findById(id).get();
    }

    @Override
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile update(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void delete(int id) {
        profileRepository.deleteById(id);
    }
}
