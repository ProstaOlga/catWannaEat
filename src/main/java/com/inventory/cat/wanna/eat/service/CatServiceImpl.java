package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.dto.CatDTO;
import com.inventory.cat.wanna.eat.exceptions.NotFoundCurrentFoodPlanException;
import com.inventory.cat.wanna.eat.exceptions.NotFoundEntityException;
import com.inventory.cat.wanna.eat.mappers.CatMapper;
import com.inventory.cat.wanna.eat.models.Cat;
import com.inventory.cat.wanna.eat.repos.CatRepo;
import com.inventory.cat.wanna.eat.service.api.CatService;
import com.inventory.cat.wanna.eat.util.ProfileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final CatRepo catRepo;

    @Override
    public List<CatDTO> getCats() {
        List<Cat> cats = (List<Cat>) catRepo.findAll();

        return cats.stream()
                .map(CatMapper.INSTANCE::catToCatDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CatDTO getCatById(Long id) {
        Cat cat = catRepo.getById(id);
           if (cat == null) {
               throw new NotFoundEntityException(Cat.class, id);
           }

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
