package com.metsoft.cqrsarticleproject.command;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
public class CreateBookCommand {

    @TargetAggregateIdentifier
    private String id;
    private String name;
    private String authorName;
    private int stock;
    private double price;
}
