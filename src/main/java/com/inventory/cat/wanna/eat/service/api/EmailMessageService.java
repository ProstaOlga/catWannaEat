package com.inventory.cat.wanna.eat.service.api;

import com.inventory.cat.wanna.eat.models.*;

import java.util.HashMap;
import java.util.Set;

public interface EmailMessageService {
    EmailMessage createMessage(String addresseeName, MessageType messageType, HashMap<String, Long> foodCount);
}
