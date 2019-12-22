package com.saurabh.sfguru.SpringBootApp.persistence.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.saurabh.sfguru.SpringBootApp.persistence.entities.Author;

@Component
public interface AuthorRepository extends CrudRepository<Author, Long> {


}
