package com.inventory.cat.wanna.eat.service.api;

import com.inventory.cat.wanna.eat.dto.AddresseeDTO;

import java.util.List;

public interface AddressBookService {
    /**
     * Получить список адресатов
     */
    List<AddresseeDTO> getAddressees();

    /**
     * Найти адресата по id
     */
    AddresseeDTO getAddresseeById(Long id);


    /**
     * Добавить нового адресата
     */
    void createAddressee(AddresseeDTO addressee);

    /**
     * Удалить адресата
     */
    void removeAddressee(Long id);

    /**
     * Изменить почту адресата
     */
    void changeAddresseesEmail(AddresseeDTO addressee);

}
