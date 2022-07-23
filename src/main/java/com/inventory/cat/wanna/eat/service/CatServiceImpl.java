package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.dto.CatDTO;
import com.inventory.cat.wanna.eat.mappers.CatMapper;
import com.inventory.cat.wanna.eat.repos.CatRepo;
import com.inventory.cat.wanna.eat.service.api.CatService;
import com.inventory.cat.wanna.eat.models.Cat;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
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
        return CatMapper.INSTANCE.catToCatDTO(catRepo.getById(id));
    }

    @Override
    public void createCat(CatDTO cat) {
        catRepo.save(CatMapper.INSTANCE.catDTOtoCat(cat));
    }

    @Override
    public void removeCat(Long id) {
        catRepo.deleteById(id);
    }
}
