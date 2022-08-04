package com.inventory.cat.wanna.eat.service.api;

import com.inventory.cat.wanna.eat.models.EmailMessage;
import com.inventory.cat.wanna.eat.models.Profile;

public interface EmailSenderService {
    void sendMessage(Profile profile, EmailMessage message);
}
