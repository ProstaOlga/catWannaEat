package com.inventory.cat.wanna.eat.exceptions;

public class UserNotHaveEntityException extends RuntimeException{

    public UserNotHaveEntityException(Class clazz, Long id){
        super(String.format("%s не найдено у пользователя с id %d", clazz.getSimpleName(), id));
    }
}
