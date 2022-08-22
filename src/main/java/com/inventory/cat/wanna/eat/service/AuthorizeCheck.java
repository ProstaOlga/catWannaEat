package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.models.Profile;
import com.inventory.cat.wanna.eat.repos.FoodRepo;
import com.inventory.cat.wanna.eat.util.ProfileUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@RequiredArgsConstructor
public class AuthorizeCheck {

    private final FoodRepo foodRepo;

    public boolean cat(Long catId){
        return ProfileUtil.getCurrentProfile().getCats()
                .stream()
                .anyMatch(cat -> cat.getId().equals(catId));
    }

    public boolean foodBag(Long foodBagId){
        return ProfileUtil.getCurrentProfile().getFoodBags()
                .stream()
                .anyMatch(foodBag -> foodBag.getId().equals(foodBagId));
    }

    public boolean food(Long foodId){
        Profile profile = ProfileUtil.getCurrentProfile();
        return foodRepo.getFoodsByProfile_Id(profile.getId())
                .stream()
                .anyMatch(food -> food.getId().equals(foodId));
    }



}
