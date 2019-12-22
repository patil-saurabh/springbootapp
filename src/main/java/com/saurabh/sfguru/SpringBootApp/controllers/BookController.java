package com.saurabh.sfguru.SpringBootApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saurabh.sfguru.SpringBootApp.persistence.repo.BookRepository;

@Controller
public class BookController {

	private BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}
	
	@RequestMapping(path="/book")
	public String getBooks(Model uiModel){
		System.out.println("Entering the getbooks method.. ");
		uiModel.addAttribute("booksData", bookRepository.findAll());
		System.out.println("Printing books: "+ bookRepository.findAll());
		return "books";
	}
	
}
