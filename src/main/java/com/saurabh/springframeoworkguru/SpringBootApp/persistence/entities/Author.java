package com.saurabh.springframeoworkguru.SpringBootApp.persistence.entities;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  // Generates value at runtime, so during compilation this would be null
	Long id;
	
	String name;
	
	@ManyToMany(mappedBy= "authors")  // This is the name of the variable in Book class that holds ref to Author.
	Set<Book> book = new HashSet<>();

	public Author(String name, Set<Book> book) {
		super();
		this.name = name;
		this.book = book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBook() {
		return book;
	}

	public void setBook(Set<Book> book) {
		this.book = book;
	}
	

}
