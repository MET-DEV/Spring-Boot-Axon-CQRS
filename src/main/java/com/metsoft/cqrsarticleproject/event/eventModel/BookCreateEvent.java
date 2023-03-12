package com.metsoft.cqrsarticleproject.event.eventModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCreateEvent {
    private String id;
    private String name;
    private String authorName;
    private int stock;
    private double price;
}
