package com.codingdojo.beltExam.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.beltExam.models.Guest;
import com.codingdojo.beltExam.repositories.GuestRepository;

@Service
public class GuestService {
	@Autowired
	private GuestRepository repo;
	
	public ArrayList<Guest> all(){
		return repo.findAll();
	}
	
	public Guest find(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Guest create(Guest guest) {
		return repo.save(guest);
	}
	
	public Guest update(Guest guest) {
		return repo.save(guest);
	}
	
	public void destroy(Long id) {
		repo.deleteById(id);
	}
	

}
