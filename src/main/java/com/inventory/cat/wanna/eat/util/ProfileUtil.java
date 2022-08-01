package com.inventory.cat.wanna.eat.util;

import com.inventory.cat.wanna.eat.models.Profile;
import com.inventory.cat.wanna.eat.repos.ProfileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ProfileUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static Profile getCurrentProfile(){
        var profileRepo = applicationContext.getBean(ProfileRepo.class);

        return profileRepo.getById(1L);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ProfileUtil.applicationContext = applicationContext;
    }
}
