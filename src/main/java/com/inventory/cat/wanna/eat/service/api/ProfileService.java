package com.inventory.cat.wanna.eat.service.api;

import com.inventory.cat.wanna.eat.dto.ProfileDTO;

import java.util.List;

public interface ProfileService {
    /**
     * Получить список адресатов
     */
    List<ProfileDTO> getUsers();

    /**
     * Найти адресата по id
     */
    ProfileDTO getUserById(Long id);


    /**
     * Добавить нового адресата
     */
    void createUser(ProfileDTO addressee);

    /**
     * Удалить адресата
     */
    void removeUser(Long id);

    /**
     * Изменить почту адресата
     */
    void updateUser(ProfileDTO addressee);

}
