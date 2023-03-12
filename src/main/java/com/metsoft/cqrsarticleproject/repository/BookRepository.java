package com.metsoft.cqrsarticleproject.repository;

import com.metsoft.cqrsarticleproject.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,String> {
}
