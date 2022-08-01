package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.dto.ProfileDTO;
import com.inventory.cat.wanna.eat.mappers.ProfileMapper;
import com.inventory.cat.wanna.eat.models.Profile;
import com.inventory.cat.wanna.eat.repos.ProfileRepo;
import com.inventory.cat.wanna.eat.service.api.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepo profileRepo;

    @Override
    public List<ProfileDTO> getUsers() {
        List<Profile> profiles = (List<Profile>) profileRepo.findAll();
        return profiles.stream()
                .map(ProfileMapper.INSTANCE::addresseeToAddresseeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProfileDTO getUserById(Long id) {
        return ProfileMapper.INSTANCE.addresseeToAddresseeDTO(profileRepo.getById(id));
    }

    @Override
    public void createUser(ProfileDTO addressee) {
        profileRepo.save(ProfileMapper.INSTANCE.addresseeDTOtoAddressee(addressee));
    }


    @Override
    public void removeUser(Long id) {
        profileRepo.deleteById(id);
    }

    @Override
    public void updateUser(ProfileDTO addressee) {

    }
}
