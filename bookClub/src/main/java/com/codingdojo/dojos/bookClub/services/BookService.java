package com.codingdojo.dojos.bookClub.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojos.bookClub.models.Book;
import com.codingdojo.dojos.bookClub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;
	
	public ArrayList<Book> all(){
		return repo.findAll();
	}
	
	public Book find(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Book create(Book book) {
		return repo.save(book);
	}
	
	public Book update(Book book) {
		return repo.save(book);
	}
	
	public void destroy(Long id) {
		repo.deleteById(id);
	}
}
