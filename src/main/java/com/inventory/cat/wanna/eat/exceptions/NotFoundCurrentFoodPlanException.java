package com.inventory.cat.wanna.eat.exceptions;

public class NotFoundCurrentFoodPlanException extends RuntimeException{
    public NotFoundCurrentFoodPlanException(String message) {
        super(message);
    }

}
