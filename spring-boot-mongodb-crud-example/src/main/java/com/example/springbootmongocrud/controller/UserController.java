package com.example.springbootmongocrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmongocrud.entity.User;
import com.example.springbootmongocrud.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		System.out.println("---- Berhasil menambahkan " + user +  " ----");
		return userService.saveUser(user);
	}
	
	@GetMapping("/list")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@PutMapping("/update/{user_id}")
	public String updateUser(@RequestBody User user, @PathVariable("user_id") Long id) {
		userService.updateUser(id, user);
		return "User ID : "+ id +" (--- Updated succesfully ---)";
	}
	
	@DeleteMapping("/delete/{user_id}")
	public String deleteUser(@PathVariable("user_id") Long id) {
		 userService.deleteUser(id);
		 return "User ID : "+ id +" (--- Deleted succesfully ---)";
	}
}
