package com.example.capstone.AadharRestApi.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstone.AadharRestApi.Entity.Admin;
import com.example.capstone.AadharRestApi.Entity.Citizens;
import com.example.capstone.AadharRestApi.Entity.User;
import com.example.capstone.AadharRestApi.Repository.AdminRepo;
import com.example.capstone.AadharRestApi.Repository.CitizensRepo;
import com.example.capstone.AadharRestApi.Repository.UserRepo;
import com.examples.capstone.AadharRestApi.Exception.AdminNotFoundException;
import com.examples.capstone.AadharRestApi.Exception.CitizenNotFoundException;
import com.examples.capstone.AadharRestApi.Exception.UserNotFoundException;

@RestController
public class RestApiController {

	@Autowired
	private AdminRepo adminrepo;

	@Autowired
	private UserRepo userrepo;

	@Autowired
	private CitizensRepo citiRepo;

	// Retrieve all admins
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/admin")
	public Iterable<Admin> getAdmin() {
		return adminrepo.findAll();
	}
	// Retrieve admin by ID
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/admin/{id}")
	public Admin getAdmin(@PathVariable("id") Integer id) {
		Optional<Admin> optAdmin = adminrepo.findById(id);
		if (optAdmin.isEmpty()) {
			throw new AdminNotFoundException(id);
		}
		return optAdmin.get();
	}
	// Create a new admin
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/admin")
	public Admin create(@RequestBody Admin admin) {
		return adminrepo.save(admin);
	}
	// Update an existing admin

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/admin")
	public Admin update(@RequestBody Admin admin) {
		return adminrepo.save(admin);
	}
	// Delete an admin by ID
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/admin/{id}")
	public void deleteadmin(@PathVariable("id") Integer id) {
		adminrepo.deleteById(id);
	}

	// User
	// Retrieve all users
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/user")
	public Iterable<User> getUser() {
		return userrepo.findAll();
	}
	// Retrieve user by ID
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		Optional<User> optUser = userrepo.findById(id);
		if (optUser.isEmpty()) {
			throw new UserNotFoundException(id);
		}
		return optUser.get();
	}
	// Create a new user
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/user")
	public User create(@RequestBody User user) {
		return userrepo.save(user);
	}
	// Update an existing user
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/user")
	public User update(@RequestBody User user) {
		return userrepo.save(user);
	}
	// Delete a user by ID
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/user/{id}")
	public void deleteuser(@PathVariable("id") Integer id) {
		userrepo.deleteById(id);
	}

	// Citizens
	// Retrieve all citizens
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/citizens")
	public Iterable<Citizens> getCitizens() {
		return citiRepo.findAll();
	}
	// Retrieve citizen by ID
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/citizens/{id}")
	public Citizens getCiti(@PathVariable("id") Integer id) {
		Optional<Citizens> optCiti = citiRepo.findById(id);
		if (optCiti.isEmpty()) {
			throw new CitizenNotFoundException(id);
		}
		return optCiti.get();
	}
	// Create a new citizen
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/citizens")
	public Citizens create(@RequestBody Citizens citi) {
		return citiRepo.save(citi);
	}
	// Update an existing citizen
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/citizens")
	public Citizens update(@RequestBody Citizens citi) {
		return citiRepo.save(citi);
	}
	// Delete a citizen by ID
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/citizens/{id}")
	public void deleteciti(@PathVariable("id") Integer id) {
		citiRepo.deleteById(id);
	}

}
