package com.inventory.cat.wanna.eat.controllers;

import com.inventory.cat.wanna.eat.dto.ProfileDTO;
import com.inventory.cat.wanna.eat.service.api.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/email")
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping()
    public HttpEntity<List<ProfileDTO>> view() {
        return new HttpEntity<>(profileService.getProfiles());
    }

    @GetMapping("/{id}")
    public HttpEntity<ProfileDTO> view(@PathVariable Long id) {
        return new HttpEntity<>(profileService.getProfileById(id));
    }

    @PostMapping()
    public void create(@RequestBody ProfileDTO user) {
        profileService.createProfile(user);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        profileService.removeProfile(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody ProfileDTO user) {
        profileService.updateProfile(user);
    }
}
