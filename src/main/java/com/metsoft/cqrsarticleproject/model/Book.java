package com.metsoft.cqrsarticleproject.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String name;
    private String authorName;
    private int stock;
    private double price;
}
