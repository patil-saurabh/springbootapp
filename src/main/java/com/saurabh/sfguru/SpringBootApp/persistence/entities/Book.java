package com.saurabh.sfguru.SpringBootApp.persistence.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String title;
	
	private String isbn;
	
	@OneToOne
	private Publisher publisher;
	
	/*
	 * name="book_author" specifies the name of the join table, and we specify which columns to be used for joining, with whom (inverse columns)
	 * Don't know how this will play when there are multiple columns.
	 * Now if you don't mention a join table then the default would be HB would create 2 join tables, BOOK_AUTHOR and another AUTHOR_BOOK.
	 * And that's not neat, repeatable, so we specifically mention the join table and the columns that need to be joined.
	 * 
	 */
	@ManyToMany
	@JoinTable(name="book_author", joinColumns = @JoinColumn(name="book_id"), 
				inverseJoinColumns= @JoinColumn(name="author_id"))  
	private Set<Author> authors = new HashSet<>();

	
	/*
	 * Default constructor is needed for the view models 
	 */
	public Book() {
	}
	
	public Book(String title, String isbn, String publisher, Set<Author> authors ) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
	}
	
	public Book(String title, String isbn, Publisher publisher) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
}
