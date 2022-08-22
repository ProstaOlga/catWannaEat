package com.inventory.cat.wanna.eat.service.api;

import com.inventory.cat.wanna.eat.dto.ProfileDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ProfileService extends UserDetailsService {
    /**
     * Получить список профайлов
     */
    List<ProfileDTO> getProfiles();

    /**
     * Найти профайл по id
     */
    ProfileDTO getProfileById(Long id);

    /**
     * Добавить новый профайл
     */
    void createProfile(ProfileDTO profile);

    /**
     * Удалить профайл
     */
    void removeProfile(Long id);

    /**
     * Изменить профайл
     */
    void updateProfile(ProfileDTO profile);

}
