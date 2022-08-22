package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.dto.CatDTO;
import com.inventory.cat.wanna.eat.exceptions.NotFoundCurrentFoodPlanException;
import com.inventory.cat.wanna.eat.exceptions.NotFoundEntityException;
import com.inventory.cat.wanna.eat.mappers.CatMapper;
import com.inventory.cat.wanna.eat.models.Cat;
import com.inventory.cat.wanna.eat.models.Profile;
import com.inventory.cat.wanna.eat.repos.CatRepo;
import com.inventory.cat.wanna.eat.service.api.CatService;
import com.inventory.cat.wanna.eat.util.ProfileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final CatRepo catRepo;
    private final AuthorizeCheck check;

    @Override
    public List<CatDTO> getCats() {
        Profile profile = ProfileUtil.getCurrentProfile();
        List<Cat> cats = profile.getCats();

        return cats.stream()
                .map(CatMapper.INSTANCE::catToCatDTO)
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("@authorizeCheck.cat(#id)")
    public CatDTO getCatById(Long id) {
        Cat cat = catRepo.findCatById(id).orElseThrow(() -> new NotFoundEntityException(Cat.class, id));


        return CatMapper.INSTANCE.catToCatDTO(cat);
    }

    @Override
    public void createCat(CatDTO cat) {
        var eCat = CatMapper.INSTANCE.catDTOtoCat(cat);
        eCat.getProfiles().add(ProfileUtil.getCurrentProfile());
        catRepo.save(eCat);
    }

    @Override
    public void removeCat(Long id) {
        catRepo.deleteById(id);
    }
}
