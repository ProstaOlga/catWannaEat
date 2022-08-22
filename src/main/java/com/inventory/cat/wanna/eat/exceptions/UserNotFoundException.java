package com.inventory.cat.wanna.eat.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String name){
        super(String.format("User с именем %s не найден", name));
    }

    public UserNotFoundException(Long id){
        super(String.format("User с логином %d не найден", id));
    }
}
