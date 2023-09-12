package com.codingdojo.dojos.bookClub.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojos.bookClub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
	public ArrayList<Book> findAll();
}
