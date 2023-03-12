package com.metsoft.cqrsarticleproject.event.eventHandler;

import com.metsoft.cqrsarticleproject.event.eventModel.BookCreateEvent;
import com.metsoft.cqrsarticleproject.model.Book;
import com.metsoft.cqrsarticleproject.repository.BookRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("book")
public class BookEventsHanler {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookEventsHanler(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }
    @EventHandler
    public void on(BookCreateEvent event){
        Book book=modelMapper.map(event,Book.class);
        bookRepository.save(book);
    }
}
