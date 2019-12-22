package com.saurabh.sfguru.SpringBootApp.persistence.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.saurabh.sfguru.SpringBootApp.persistence.entities.Author;
import com.saurabh.sfguru.SpringBootApp.persistence.entities.Book;
import com.saurabh.sfguru.SpringBootApp.persistence.entities.Publisher;
import com.saurabh.sfguru.SpringBootApp.persistence.repo.AuthorRepository;
import com.saurabh.sfguru.SpringBootApp.persistence.repo.BookRepository;
import com.saurabh.sfguru.SpringBootApp.persistence.repo.PublisherRepository;


/**
 * This class would add the default data into DB so that we don't need to initialize the data again and again. 
 * The event that this captures is ContextRefreshedEvent which means whenever the applicatoin context is refreshed, this would be run.
 * 
 * @author saurabh
 *
 */

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("Initializing default data into DB through DevBootstramp...");
		initData();
		
	}
	
    private void initData(){
    	//Eric
        Author eric = new Author("Eric", "Evans");
        Publisher pub1= new Publisher("Penguin Publishers","Street 1, NY, USA");
        
        Book  ddd = new Book("Domain Driven Design", "1234", pub1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(pub1);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher pub2= new Publisher("Sun and Stars","Mumbai, India");
        Book noEJB = new Book("J2EE Development without EJB", "23444", pub2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(pub2);
        bookRepository.save(noEJB);
    }	
	

}
