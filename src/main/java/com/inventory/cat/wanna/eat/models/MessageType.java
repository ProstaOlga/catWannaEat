package com.inventory.cat.wanna.eat.models;

import java.util.Arrays;

public enum MessageType {
    FOOD_IS_RUNNING_OUT("Еда для котиков заканчивается!", "Добрый день, %s! Хотим обратить ваше внимание, что:%s. Рекомендуем пополнить ваши запасы!");


    private final String bodyText;
    private final String title;

    MessageType(String title, String bodyText) {
        this.bodyText = bodyText;
        this.title = title;
    }

    public static String getBodyText(MessageType messageType) {
        return Arrays.stream(MessageType.values())
                .filter(value -> value.equals(messageType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Message type not found"))
                .bodyText;
    }

    public static String getTitle(MessageType messageType) {
        return Arrays.stream(MessageType.values())
                .filter(value -> value.equals(messageType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Message type not found"))
                .title;
    }
}
