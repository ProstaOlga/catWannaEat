package com.inventory.cat.wanna.eat.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class EmailMessage {
    private String title;
    private String body;
    private String signature;

}
