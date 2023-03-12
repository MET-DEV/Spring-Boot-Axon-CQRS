package com.metsoft.cqrsarticleproject.controller.queryController;

import com.metsoft.cqrsarticleproject.model.Book;
import com.metsoft.cqrsarticleproject.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookQueryController {
    private final BookRepository bookRepository;

    public BookQueryController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping()
    public List<Book> findAll(){
        return bookRepository.findAll();
    }
}
