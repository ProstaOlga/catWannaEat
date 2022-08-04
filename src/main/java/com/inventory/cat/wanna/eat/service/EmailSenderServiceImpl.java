package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.models.EmailMessage;
import com.inventory.cat.wanna.eat.models.Profile;
import com.inventory.cat.wanna.eat.service.api.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {
    @Override
    public void sendMessage(Profile profile, EmailMessage message) {

    }
}
