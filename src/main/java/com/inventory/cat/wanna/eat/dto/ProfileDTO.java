package com.inventory.cat.wanna.eat.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfileDTO {
    private Long id;
    private String name;
    private String email;
    private List<CatDTO> cats;
}
