package com.saurabh.sfguru.SpringBootApp.persistence.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.saurabh.sfguru.SpringBootApp.persistence.entities.Publisher;

@Component
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
