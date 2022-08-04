package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.models.*;
import com.inventory.cat.wanna.eat.repos.ProfileRepo;
import com.inventory.cat.wanna.eat.service.api.EmailMessageService;
import com.inventory.cat.wanna.eat.service.api.EmailSenderService;
import com.inventory.cat.wanna.eat.service.api.FoodBagService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final ProfileRepo profileRepo;
    private final FoodBagService foodBagService;
    private final EmailMessageService emailMessageService;
    private final EmailSenderService emailSenderService;


//    @Scheduled(cron = "19 0 0 * * *")
    @Scheduled(initialDelay = 1000, fixedDelay = 60000)
    @Transactional
    private void checkEndingFoodCount(){

        List<Profile> profiles = (List<Profile>) profileRepo.findAll();

        for (Profile profile : profiles){
            HashMap<String, Long> endingFoodBags = foodBagService.checkRunningOutFoods(profile);
            if (!endingFoodBags.isEmpty()){
                EmailMessage message = emailMessageService.createMessage(MessageType.FOOD_IS_RUNNING_OUT, endingFoodBags);
                emailSenderService.sendMessage(profile, message);
            }
        }
    }

}
