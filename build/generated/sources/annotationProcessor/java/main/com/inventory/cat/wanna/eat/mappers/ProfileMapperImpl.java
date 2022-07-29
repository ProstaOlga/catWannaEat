package com.inventory.cat.wanna.eat.mappers;

import com.inventory.cat.wanna.eat.dto.CatDTO;
import com.inventory.cat.wanna.eat.dto.FoodDTO;
import com.inventory.cat.wanna.eat.dto.FoodPlanDTO;
import com.inventory.cat.wanna.eat.dto.MealDTO;
import com.inventory.cat.wanna.eat.dto.ProfileDTO;
import com.inventory.cat.wanna.eat.models.Cat;
import com.inventory.cat.wanna.eat.models.Food;
import com.inventory.cat.wanna.eat.models.FoodPlan;
import com.inventory.cat.wanna.eat.models.Meal;
import com.inventory.cat.wanna.eat.models.Profile;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-29T18:20:37+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class ProfileMapperImpl implements ProfileMapper {

    @Override
    public Profile addresseeDTOtoAddressee(ProfileDTO profileDTO) {
        if ( profileDTO == null ) {
            return null;
        }

        Profile profile = new Profile();

        profile.setId( profileDTO.getId() );
        profile.setName( profileDTO.getName() );
        profile.setEmail( profileDTO.getEmail() );
        profile.setCats( catDTOListToCatList( profileDTO.getCats() ) );

        return profile;
    }

    @Override
    public ProfileDTO addresseeToAddresseeDTO(Profile profile) {
        if ( profile == null ) {
            return null;
        }

        ProfileDTO profileDTO = new ProfileDTO();

        profileDTO.setId( profile.getId() );
        profileDTO.setName( profile.getName() );
        profileDTO.setEmail( profile.getEmail() );
        profileDTO.setCats( catListToCatDTOList( profile.getCats() ) );

        return profileDTO;
    }

    protected List<Profile> profileDTOListToProfileList(List<ProfileDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Profile> list1 = new ArrayList<Profile>( list.size() );
        for ( ProfileDTO profileDTO : list ) {
            list1.add( addresseeDTOtoAddressee( profileDTO ) );
        }

        return list1;
    }

    protected Food foodDTOToFood(FoodDTO foodDTO) {
        if ( foodDTO == null ) {
            return null;
        }

        Food food = new Food();

        food.setId( foodDTO.getId() );
        food.setFoodType( foodDTO.getFoodType() );

        return food;
    }

    protected Meal mealDTOToMeal(MealDTO mealDTO) {
        if ( mealDTO == null ) {
            return null;
        }

        Meal meal = new Meal();

        meal.setId( mealDTO.getId() );
        meal.setFood( foodDTOToFood( mealDTO.getFood() ) );
        meal.setWeight( mealDTO.getWeight() );
        meal.setTimesOfDay( mealDTO.getTimesOfDay() );
        meal.setFoodPlan( foodPlanDTOToFoodPlan( mealDTO.getFoodPlan() ) );

        return meal;
    }

    protected List<Meal> mealDTOListToMealList(List<MealDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Meal> list1 = new ArrayList<Meal>( list.size() );
        for ( MealDTO mealDTO : list ) {
            list1.add( mealDTOToMeal( mealDTO ) );
        }

        return list1;
    }

    protected FoodPlan foodPlanDTOToFoodPlan(FoodPlanDTO foodPlanDTO) {
        if ( foodPlanDTO == null ) {
            return null;
        }

        FoodPlan foodPlan = new FoodPlan();

        foodPlan.setId( foodPlanDTO.getId() );
        foodPlan.setName( foodPlanDTO.getName() );
        foodPlan.setCurrent( foodPlanDTO.isCurrent() );
        foodPlan.setMeals( mealDTOListToMealList( foodPlanDTO.getMeals() ) );

        return foodPlan;
    }

    protected List<FoodPlan> foodPlanDTOListToFoodPlanList(List<FoodPlanDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<FoodPlan> list1 = new ArrayList<FoodPlan>( list.size() );
        for ( FoodPlanDTO foodPlanDTO : list ) {
            list1.add( foodPlanDTOToFoodPlan( foodPlanDTO ) );
        }

        return list1;
    }

    protected Cat catDTOToCat(CatDTO catDTO) {
        if ( catDTO == null ) {
            return null;
        }

        Cat cat = new Cat();

        cat.setId( catDTO.getId() );
        cat.setName( catDTO.getName() );
        cat.setAge( catDTO.getAge() );
        cat.setWeight( catDTO.getWeight() );
        cat.setBreed( catDTO.getBreed() );
        cat.setProfiles( profileDTOListToProfileList( catDTO.getProfiles() ) );
        cat.setFoodPlans( foodPlanDTOListToFoodPlanList( catDTO.getFoodPlans() ) );

        return cat;
    }

    protected List<Cat> catDTOListToCatList(List<CatDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Cat> list1 = new ArrayList<Cat>( list.size() );
        for ( CatDTO catDTO : list ) {
            list1.add( catDTOToCat( catDTO ) );
        }

        return list1;
    }

    protected List<ProfileDTO> profileListToProfileDTOList(List<Profile> list) {
        if ( list == null ) {
            return null;
        }

        List<ProfileDTO> list1 = new ArrayList<ProfileDTO>( list.size() );
        for ( Profile profile : list ) {
            list1.add( addresseeToAddresseeDTO( profile ) );
        }

        return list1;
    }

    protected FoodDTO foodToFoodDTO(Food food) {
        if ( food == null ) {
            return null;
        }

        FoodDTO foodDTO = new FoodDTO();

        foodDTO.setId( food.getId() );
        foodDTO.setFoodType( food.getFoodType() );

        return foodDTO;
    }

    protected MealDTO mealToMealDTO(Meal meal) {
        if ( meal == null ) {
            return null;
        }

        MealDTO mealDTO = new MealDTO();

        mealDTO.setId( meal.getId() );
        mealDTO.setFood( foodToFoodDTO( meal.getFood() ) );
        mealDTO.setWeight( meal.getWeight() );
        mealDTO.setTimesOfDay( meal.getTimesOfDay() );
        mealDTO.setFoodPlan( foodPlanToFoodPlanDTO( meal.getFoodPlan() ) );

        return mealDTO;
    }

    protected List<MealDTO> mealListToMealDTOList(List<Meal> list) {
        if ( list == null ) {
            return null;
        }

        List<MealDTO> list1 = new ArrayList<MealDTO>( list.size() );
        for ( Meal meal : list ) {
            list1.add( mealToMealDTO( meal ) );
        }

        return list1;
    }

    protected FoodPlanDTO foodPlanToFoodPlanDTO(FoodPlan foodPlan) {
        if ( foodPlan == null ) {
            return null;
        }

        FoodPlanDTO foodPlanDTO = new FoodPlanDTO();

        foodPlanDTO.setId( foodPlan.getId() );
        foodPlanDTO.setName( foodPlan.getName() );
        foodPlanDTO.setCurrent( foodPlan.isCurrent() );
        foodPlanDTO.setMeals( mealListToMealDTOList( foodPlan.getMeals() ) );

        return foodPlanDTO;
    }

    protected List<FoodPlanDTO> foodPlanListToFoodPlanDTOList(List<FoodPlan> list) {
        if ( list == null ) {
            return null;
        }

        List<FoodPlanDTO> list1 = new ArrayList<FoodPlanDTO>( list.size() );
        for ( FoodPlan foodPlan : list ) {
            list1.add( foodPlanToFoodPlanDTO( foodPlan ) );
        }

        return list1;
    }

    protected CatDTO catToCatDTO(Cat cat) {
        if ( cat == null ) {
            return null;
        }

        CatDTO catDTO = new CatDTO();

        catDTO.setId( cat.getId() );
        catDTO.setName( cat.getName() );
        catDTO.setAge( cat.getAge() );
        catDTO.setWeight( cat.getWeight() );
        catDTO.setBreed( cat.getBreed() );
        catDTO.setProfiles( profileListToProfileDTOList( cat.getProfiles() ) );
        catDTO.setFoodPlans( foodPlanListToFoodPlanDTOList( cat.getFoodPlans() ) );

        return catDTO;
    }

    protected List<CatDTO> catListToCatDTOList(List<Cat> list) {
        if ( list == null ) {
            return null;
        }

        List<CatDTO> list1 = new ArrayList<CatDTO>( list.size() );
        for ( Cat cat : list ) {
            list1.add( catToCatDTO( cat ) );
        }

        return list1;
    }
}
