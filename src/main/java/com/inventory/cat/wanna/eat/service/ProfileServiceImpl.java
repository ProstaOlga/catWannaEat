package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.dto.ProfileDTO;
import com.inventory.cat.wanna.eat.mappers.ProfileMapper;
import com.inventory.cat.wanna.eat.models.Profile;
import com.inventory.cat.wanna.eat.repos.ProfileRepo;
import com.inventory.cat.wanna.eat.service.api.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ApplicationContext applicationContext;

    private final ProfileRepo profileRepo;

    @Override
    public List<ProfileDTO> getProfiles() {
        List<Profile> profiles = (List<Profile>) profileRepo.findAll();
        return profiles.stream()
                .map(ProfileMapper.INSTANCE::addresseeToAddresseeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProfileDTO getProfileById(Long id) {
        return ProfileMapper.INSTANCE.addresseeToAddresseeDTO(profileRepo.findById(id).orElseThrow());
    }

    @Override
    public void createProfile(ProfileDTO addressee) {
        profileRepo.save(ProfileMapper.INSTANCE.addresseeDTOtoAddressee(addressee));
    }

    @Override
    public void removeProfile(Long id) {
        profileRepo.deleteById(id);
    }

    @Override
    public void updateProfile(ProfileDTO addressee) {

    }

    @Override
    public UserDetails loadUserByUsername(String name) {
        return profileRepo.findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Пользователь %s не найден.", name)));
    }

}
