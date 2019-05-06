package com.saurabh.springframeoworkguru.SpringBootApp.persistence.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String title;
	
	private String isbn;
	
	/*
	 * name="book_author" specifies the name of the join table, and we specify which columns to be used for joining, with whom(inverse columns)
	 * Don't know how this will play when there are multiple columns.
	 */
	@ManyToMany
	@JoinTable(name="book_author", joinColumns = @JoinColumn(name="book_id"), 
				inverseJoinColumns= @JoinColumn(name="author_id"))  
	private Set<Author> authors = new HashSet<>();

	public Book(Long id, String title, String isbn, Set<Author> authors) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
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


	
	
	
	
	
	
	
	
}
