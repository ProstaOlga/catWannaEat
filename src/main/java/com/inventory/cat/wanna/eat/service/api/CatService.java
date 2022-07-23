package com.inventory.cat.wanna.eat.service.api;

import com.inventory.cat.wanna.eat.dto.CatDTO;
import com.inventory.cat.wanna.eat.models.Cat;

import java.util.List;

public interface CatService {
    /**
     * Получить список котиков
     */
    List<CatDTO> getCats();

    /**
     * Получить котика по id
     */
    CatDTO getCatById(Long id);

    /**
     * Добавить нового котика
     */
    void createCat(CatDTO cat);

    /**
     * Удалить котика
     */
    void removeCat(Long id);
}
