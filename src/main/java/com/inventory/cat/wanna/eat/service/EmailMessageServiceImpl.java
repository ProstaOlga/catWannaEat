package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.models.EmailMessage;
import com.inventory.cat.wanna.eat.models.FoodBag;
import com.inventory.cat.wanna.eat.models.MessageType;
import com.inventory.cat.wanna.eat.service.api.EmailMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmailMessageServiceImpl implements EmailMessageService {
    private EmailMessage emailMessage;
    private void checkMessageType(MessageType messageType, Set<FoodBag> foodBags) {

    }

    @Override
    public EmailMessage createMessage(String addresseeName, MessageType messageType, HashMap<String, Long> foodCount) {
        EmailMessage emailMessage = new EmailMessage();
        String runningOutFoods = generateFoodReport(foodCount);

        emailMessage.setTitle(MessageType.getTitle(messageType));
        emailMessage.setBody(String.format(MessageType.getBodyText(messageType), addresseeName, runningOutFoods));
        emailMessage.setSignature("\nС уважением, служба контроля за едой в холодильнике!");

        return emailMessage;
    }

    private String generateFoodReport(HashMap<String, Long> foodCount) {
        return foodCount.entrySet().stream()
                .map(set -> String.format(" %s осталось на %d дней", set.getKey().toLowerCase(), set.getValue()))
                .collect(Collectors.joining(","));
    }
}
