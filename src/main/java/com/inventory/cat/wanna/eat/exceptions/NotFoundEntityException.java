package com.inventory.cat.wanna.eat.exceptions;

public class NotFoundEntityException extends RuntimeException{
    public NotFoundEntityException(Class clazz, Long id) {
        super(String.format("Объект %s с id %d не найден.", clazz.getSimpleName(), id));
    }
}
