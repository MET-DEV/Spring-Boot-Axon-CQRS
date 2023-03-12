package com.metsoft.cqrsarticleproject.aggregate;

import com.metsoft.cqrsarticleproject.command.CreateBookCommand;
import com.metsoft.cqrsarticleproject.event.eventModel.BookCreateEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.modelmapper.ModelMapper;

@Aggregate
@Getter
@NoArgsConstructor
public class BookAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String authorName;
    private int stock;
    private double price;
    @CommandHandler
    public BookAggregate(CreateBookCommand bookCommand){
        BookCreateEvent bookCreateEvent=new ModelMapper().map(bookCommand,BookCreateEvent.class);
        AggregateLifecycle.apply(bookCreateEvent);
    }
    @EventSourcingHandler
    public void on(BookCreateEvent bookCreateEvent){
        this.id=bookCreateEvent.getId();
        this.name= bookCreateEvent.getName();
        this.authorName= bookCreateEvent.getAuthorName();
        this.price=bookCreateEvent.getPrice();
        this.stock=bookCreateEvent.getStock();
    }

}
