package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.dto.FoodBagDTO;
import com.inventory.cat.wanna.eat.mappers.FoodBagMapper;
import com.inventory.cat.wanna.eat.models.FoodBag;
import com.inventory.cat.wanna.eat.repos.CatRepo;
import com.inventory.cat.wanna.eat.repos.FoodBagRepo;
import com.inventory.cat.wanna.eat.repos.FoodRepo;
import com.inventory.cat.wanna.eat.service.api.FoodBagService;
import com.inventory.cat.wanna.eat.util.ProfileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodBagServiceImpl implements FoodBagService {

    private final FoodBagRepo foodBagRepo;
    private final FoodRepo foodRepo;
    @Override
    public List<FoodBagDTO> getFoodBags() {
        List<FoodBag> foodBags = (List<FoodBag>) foodBagRepo.findAll();
        return foodBags.stream().map(FoodBagMapper.INSTANCE::foodBagToFoodBagDTO).collect(Collectors.toList());
    }

    @Override
    public FoodBagDTO getFoodBagById(Long id) {
        return FoodBagMapper.INSTANCE.foodBagToFoodBagDTO(foodBagRepo.getById(id));
    }

    @Override
    public void createFoodBag( FoodBagDTO foodBag) {
        FoodBag eFoodBag = FoodBagMapper.INSTANCE.foodBagDTOtoFoodBag(foodBag);
        eFoodBag.setFood(foodRepo.getById(foodBag.getFoodId()));
        eFoodBag.setProfile(ProfileUtil.getCurrentProfile());
        foodBagRepo.save(eFoodBag);
    }

    @Override
    public void removeFoodBag(Long id) {
        foodBagRepo.deleteById(id);
    }

    @Override
    public void updateFoodBag(Long id, FoodBagDTO foodBag) {
        FoodBag changeFoodBag;
        changeFoodBag = FoodBagMapper.INSTANCE.foodBagDTOtoFoodBag(foodBag);
        foodBagRepo.save(changeFoodBag);
    }

}
