package com.codingdojo.dojos.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojos.models.Dojo;
import com.codingdojo.dojos.models.Ninja;
import com.codingdojo.dojos.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository repo;
	
	public ArrayList<Ninja> all() {
		return repo.findAll();
	}
	
	public Ninja find(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Ninja create(Ninja n) {
		return repo.save(n);
	}
	
	public Ninja update(Ninja n) {
		return repo.save(n);
	}
	
	public void destroy(Long id) {
		repo.deleteById(id);
	}
}