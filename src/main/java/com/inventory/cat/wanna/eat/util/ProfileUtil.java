package com.inventory.cat.wanna.eat.util;

import com.inventory.cat.wanna.eat.exceptions.UserNotFoundException;
import com.inventory.cat.wanna.eat.models.Profile;
import com.inventory.cat.wanna.eat.repos.ProfileRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User;

@Component
@RequiredArgsConstructor
public class ProfileUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @SneakyThrows
    public static Profile getCurrentProfile(){
//        var profileRepo = applicationContext.getBean(ProfileRepo.class);
//        return profileRepo.getById(1L);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return (Profile) authentication.getPrincipal();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ProfileUtil.applicationContext = applicationContext;
    }
}
