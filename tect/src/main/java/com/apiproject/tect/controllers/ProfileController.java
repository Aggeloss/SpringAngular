package com.apiproject.tect.controllers;

import com.apiproject.tect.entities.Product;
import com.apiproject.tect.entities.Profile;
import com.apiproject.tect.services.ProductService;
import com.apiproject.tect.services.ProfileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

//    @GetMapping
//    public Iterable<Profile> getAllProfiles() {
//        return profileService.findAll();
//    }

    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable int id) {
        return profileService.find(id);
    }

    @PostMapping
    public Profile saveProfile(@RequestBody Profile profile) {
        return profileService.save(profile);
    }

    @PutMapping
    public Profile updateProfile(@RequestBody Profile profile) {
        return profileService.update(profile);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable int id) {
        profileService.delete(id);
    }
}