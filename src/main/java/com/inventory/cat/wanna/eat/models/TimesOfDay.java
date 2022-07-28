package com.inventory.cat.wanna.eat.models;

import java.util.Arrays;

public enum TimesOfDay {
    MORNING("Утро"),
    DAY("День"),
    EVENiNG("Вечер"),
    NIGHT("Ночь"),
    NO_VALUE("не установлено");

    String stringTimesOfDay;
    private TimesOfDay(String stringTimesOfDay){
    }

    public static TimesOfDay getTimesOfDay(String str){
        return Arrays.stream(TimesOfDay.values())
                .filter(value -> value.stringTimesOfDay.equalsIgnoreCase(str))
                .findFirst()
                .orElse(NO_VALUE);
    }

    public static String getString(TimesOfDay timesOfDay){
        return Arrays.stream(TimesOfDay.values())
                .filter(value -> value.equals(timesOfDay))
                .findFirst()
                .orElse(NO_VALUE)
                .stringTimesOfDay;
    }
}
