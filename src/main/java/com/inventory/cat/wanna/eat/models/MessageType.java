package com.inventory.cat.wanna.eat.models;

import java.util.Arrays;

public enum MessageType {
    FOOD_IS_RUNNING_OUT ("Добрый день! Хотим обратить ваше внимание, что количество \"%s\" в вашем холодильнике равно %d. Рекомендуем пополнить ваши запасы!");


    private final String message;

    private MessageType(String message) {
        this.message = message;
    }


    public static String getString(MessageType messageType){
        return Arrays.stream(MessageType.values())
                .filter(value -> value.equals(messageType))
                .findFirst()
                .get()
                .message;
    }
}
