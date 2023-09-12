package com.codingdojo.beltExam.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.beltExam.models.Guest;


public interface GuestRepository extends CrudRepository<Guest, Long>{
	public ArrayList<Guest> findAll();

}
