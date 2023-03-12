package com.metsoft.cqrsarticleproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookDto {
    private String name;
    private String authorName;
    private int stock;
    private double price;
}
