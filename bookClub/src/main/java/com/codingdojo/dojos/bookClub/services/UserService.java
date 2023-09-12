package com.codingdojo.dojos.bookClub.services;

import java.util.ArrayList;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.dojos.bookClub.models.Book;
import com.codingdojo.dojos.bookClub.models.LoginUser;
import com.codingdojo.dojos.bookClub.models.User;
import com.codingdojo.dojos.bookClub.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {

	@Autowired
	private UserRepository uRepo;
	
	public User create(User u) {
		return uRepo.save(u);
	}
	
	public Boolean isValid(BindingResult result, User user, HttpSession session) {
		
		User userInDb = uRepo.findByEmail(user.getEmail()).orElse(null);
		
		if(userInDb != null) {
			result.rejectValue("email", "unique", "cannot use same email");
		}
		
		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Password must match comfirm password");
			
		}
		
		if(result.hasErrors()) {
			return false;
		}
		
		String hashed= BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		
		user.setPassword(hashed);
		return true;
	}
	
	public User find(Long id) {
		return uRepo.findById(id).orElse(null);
	}
	
	
	public Boolean attemptLogin(BindingResult result, LoginUser user, HttpSession session) {
		
		if(result.hasErrors()) {
		return false;
		}
		
		User userInDb = uRepo.findByEmail(user.getEmail()).orElse(null);
		
		if(userInDb == null) {
			result.rejectValue("email", "invalid", "Invalid login");
			return false;
		}
		Boolean matches = BCrypt.checkpw(user.getPassword(), userInDb.getPassword());
		
		if(!matches) {
			result.rejectValue("password", "invalid", "Invalid login");
			return false;
		}
		
		session.setAttribute("loggedIn", userInDb.getId());
		return true;
	}
	
	public User findById(Long id) {
		Optional<User> result = uRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	public ArrayList<User> all(){
		return uRepo.findAll();
	}

	
	public User update(User user) {
		return uRepo.save(user);
	}
	
	public void destroy(Long id) {
		uRepo.deleteById(id);
	}
}
