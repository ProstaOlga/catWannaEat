package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.exceptions.NotFoundCurrentFoodPlanException;
import com.inventory.cat.wanna.eat.models.EmailMessage;
import com.inventory.cat.wanna.eat.models.MessageType;
import com.inventory.cat.wanna.eat.models.Profile;
import com.inventory.cat.wanna.eat.repos.ProfileRepo;
import com.inventory.cat.wanna.eat.service.api.EmailMessageService;
import com.inventory.cat.wanna.eat.service.api.EmailSenderService;
import com.inventory.cat.wanna.eat.service.api.FoodBagService;
import com.inventory.cat.wanna.eat.service.api.FoodConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final ProfileRepo profileRepo;
    private final FoodBagService foodBagService;
    private final EmailMessageService emailMessageService;
    private final EmailSenderService emailSenderService;
    private final FoodConsumerService foodConsumerService;

    @PostConstruct
//    @Scheduled(cron = "0 0 19 ? * *")
    @Transactional
    public void checkEndingFoodCount(){
        List<Profile> profiles = (List<Profile>) profileRepo.findAll();
        for (Profile profile : profiles) {
            HashMap<String, Long> endingFoodBags = foodBagService.getRunningOutFoods(profile);
            System.out.println(endingFoodBags);
            if (!endingFoodBags.isEmpty()) {
                EmailMessage message = emailMessageService.createMessage(profile.getName(), MessageType.FOOD_IS_RUNNING_OUT, endingFoodBags);
                log.info("Message: {}, \nProfile: {}", message, profile);
                emailSenderService.sendMessage(profile, message);
            }
        }
    }

    @PostConstruct
//    @Scheduled(cron = "0 0 4 ? * *")
    @Transactional
    public void DailyConsumeFood() {
        List<Profile> profiles = (List<Profile>) profileRepo.findAll();
        profiles.forEach(foodConsumerService::consumeFood);
    }
}
