package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.models.EmailMessage;
import com.inventory.cat.wanna.eat.models.Profile;
import com.inventory.cat.wanna.eat.service.api.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService{

    private final JavaMailSender javaMailSender;
    @Override
    public void sendMessage(Profile profile, EmailMessage message) {
        String addressee = profile.getEmail();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(addressee);
        simpleMailMessage.setSubject(message.getTitle());
        simpleMailMessage.setText(message.getBody() + message.getSignature());
        simpleMailMessage.setFrom("ola.learningjava@mail.ru");
        javaMailSender.send(simpleMailMessage);
    }


}
