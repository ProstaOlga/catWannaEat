package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.dto.FoodBagDTO;
import com.inventory.cat.wanna.eat.exceptions.NotFoundEntityException;
import com.inventory.cat.wanna.eat.mappers.FoodBagMapper;
import com.inventory.cat.wanna.eat.models.*;
import com.inventory.cat.wanna.eat.repos.FoodBagRepo;
import com.inventory.cat.wanna.eat.repos.FoodRepo;
import com.inventory.cat.wanna.eat.repos.ProfileRepo;
import com.inventory.cat.wanna.eat.service.api.FoodBagService;
import com.inventory.cat.wanna.eat.util.ProfileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private final AuthorizeCheck authorizeCheck;

    @Override
    public List<FoodBagDTO> getFoodBags() {
        Profile profile = ProfileUtil.getCurrentProfile();
        List<FoodBag> foodBags = profile.getFoodBags();
        return foodBags.stream().map(FoodBagMapper.INSTANCE::foodBagToFoodBagDTO).collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("@authorizeCheck.foodBag(#id)")
    public FoodBagDTO getFoodBagById(Long id) {
        FoodBag foodBag = foodBagRepo.getById(id);
        if (foodBag == null) {
            throw new NotFoundEntityException(FoodBag.class, id);
        }

        return FoodBagMapper.INSTANCE.foodBagToFoodBagDTO(foodBag);
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
        FoodBag eFoodBag;
        eFoodBag = FoodBagMapper.INSTANCE.foodBagDTOtoFoodBag(foodBag);
        updateFoodBag(eFoodBag);
    }

    @Override
    public void updateFoodBag(FoodBag foodBag) {
        foodBagRepo.save(foodBag);
    }


    @Override
    @Transactional
    public HashMap<String, Long> getRunningOutFoods(Profile profile) {
        HashMap<String, Long> runningOutFoods = new HashMap<>();

        HashMap<String, Long> presentFoodsCount = getFoodsCount(profile);
        presentFoodsCount.entrySet().stream()
                .filter(set -> checkFoodInPresentFoodPlans(set.getKey(), profile))
                .filter(set ->  checkRemainingDays(getRestOfTheFood(set, profile)))
                .forEach(set -> runningOutFoods.put(set.getKey(), getRestOfTheFood(set, profile)));

        return runningOutFoods;

    }

    private boolean checkFoodInPresentFoodPlans(String food, Profile profile) {
        return profile.getCats().stream()
                .map(Cat::getCurrentFoodPlan)
                .anyMatch(foodPlan -> foodPlan.isFood(food));

    }

    private boolean checkRemainingDays(Long restOfTheFood){
        return restOfTheFood < 7L && restOfTheFood >= 0;
    }

    private HashMap<String, Long> getFoodsCount(Profile profile) {
        HashMap<String, Long> presentFoodsCount = new HashMap<>();
        List<Food> currentFoods = profile.getPresentFoodTypes();

        currentFoods.forEach(food -> presentFoodsCount.put(food.getFoodType(), profile.getPresentCountFoodType(food)));

        return presentFoodsCount;
    }

    /**
     *
     * @param foodCountSet
     * @param profile
     * @return
     * value = 0 - food bag is empty;
     * value > 0 - days, the food has left
     * value = -1 - this food doesn`t take part in current food plan
     */
    private Long getRestOfTheFood(Map.Entry<String, Long> foodCountSet, Profile profile) {
        Long dailyConsumingForAllCats;
        dailyConsumingForAllCats  = profile.getCats().stream()
                    .map(Cat::getCurrentFoodPlan)
                    .mapToLong(foodPlan -> foodPlan.getDailyConsuming(foodCountSet.getKey()))
                    .filter(dailyPortion -> dailyPortion > 0)
                    .reduce(0L, Long::sum);

            return dailyConsumingForAllCats == 0 ? -1 : foodCountSet.getValue() / dailyConsumingForAllCats;


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
