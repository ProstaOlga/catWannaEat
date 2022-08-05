package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.dto.FoodBagDTO;
import com.inventory.cat.wanna.eat.mappers.FoodBagMapper;
import com.inventory.cat.wanna.eat.models.*;
import com.inventory.cat.wanna.eat.repos.FoodBagRepo;
import com.inventory.cat.wanna.eat.repos.FoodRepo;
import com.inventory.cat.wanna.eat.repos.ProfileRepo;
import com.inventory.cat.wanna.eat.service.api.FoodBagService;
import com.inventory.cat.wanna.eat.util.ProfileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodBagServiceImpl implements FoodBagService {

    private final ProfileRepo profileRepo;
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
    public void createFoodBag(FoodBagDTO foodBag) {
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


    @Override
    @Transactional
    public HashMap<String, Long> checkRunningOutFoods(Profile profile) {
        HashMap<String, Long> runningOutFoods = new HashMap<>();

        HashMap<String, Long> presentFoodsCount = getFoodsCount(profile);
        presentFoodsCount.entrySet().stream()
                .filter(set -> getRestOfTheFood(set, profile) < 7L)
                .forEach(set -> runningOutFoods.put(set.getKey(), getRestOfTheFood(set, profile)));

        return runningOutFoods;

    }

    private HashMap<String, Long> getFoodsCount(Profile profile) {
        HashMap<String, Long> presentFoodsCount = new HashMap<>();
        List<Food> currentFoods = profile.getPresentFoodTypes();

        currentFoods.forEach(food -> presentFoodsCount.put(food.getFoodType(), profile.getPresentCountFoodType(food)));

        return presentFoodsCount;
    }


    private Long getRestOfTheFood(Map.Entry<String, Long> foodCountSet, Profile profile) {
        Long dailyConsumingForAllCats =  profile.getCats().stream()
                .map(Cat::getCurrentFoodPlan)
                .mapToLong(foodPlan -> foodPlan.getDailyConsuming(foodCountSet.getKey()))
                .filter(dailyPortion -> dailyPortion > 0)
                .reduce(0L, Long::sum);

        return foodCountSet.getValue() / dailyConsumingForAllCats;


//        List<Cat> cats = profile.getCats();
//        Long result = foodCountSet.getValue();
//
//        for (Cat cat : cats) {
//            FoodPlan foodPlan = cat.getCurrentFoodPlan();
//            if (foodPlan != null) {
//                Long dailyPortion = foodPlan.getDailyPortion(foodCountSet.getKey());
//                result = foodCountSet.getValue() / dailyPortion;
//            }
//        }
//
//        return result;
    }


}
