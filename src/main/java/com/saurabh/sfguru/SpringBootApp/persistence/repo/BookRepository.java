package com.saurabh.sfguru.SpringBootApp.persistence.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.saurabh.sfguru.SpringBootApp.persistence.entities.Book;

@Component
public interface BookRepository extends CrudRepository<Book, Long> {

	
}
