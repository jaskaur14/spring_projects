package com.codingdojo.dojos.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojos.models.Dojo;
import com.codingdojo.dojos.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	private DojoRepository repo;
	
	public ArrayList<Dojo> all() {
		return repo.findAll();
	}
	
	public Dojo find(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Dojo create(Dojo d) {
		return repo.save(d);
	}
	
	public Dojo update(Dojo d) {
		return repo.save(d);
	}
	
	public void destroy(Long id) {
		repo.deleteById(id);
	}
}
