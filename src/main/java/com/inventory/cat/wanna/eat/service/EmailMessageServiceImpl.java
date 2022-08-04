package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.models.EmailMessage;
import com.inventory.cat.wanna.eat.models.Food;
import com.inventory.cat.wanna.eat.models.FoodBag;
import com.inventory.cat.wanna.eat.models.MessageType;
import com.inventory.cat.wanna.eat.service.api.EmailMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmailMessageServiceImpl implements EmailMessageService {
    private EmailMessage emailMessage;



    private void checkMessageType(MessageType messageType, Set<FoodBag> foodBags) {

    }

    @Override
    public EmailMessage createMessage(MessageType messageType, HashMap<String, Long> foodCount) {
        return null;
    }
}
