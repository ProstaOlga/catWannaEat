package com.inventory.cat.wanna.eat.service.api;

import com.inventory.cat.wanna.eat.models.EmailMessage;
import com.inventory.cat.wanna.eat.models.Food;
import com.inventory.cat.wanna.eat.models.FoodBag;
import com.inventory.cat.wanna.eat.models.MessageType;

import java.util.HashMap;
import java.util.Set;

public interface EmailMessageService {


    EmailMessage createMessage(MessageType messageType, HashMap<String, Long> foodCount);
}
