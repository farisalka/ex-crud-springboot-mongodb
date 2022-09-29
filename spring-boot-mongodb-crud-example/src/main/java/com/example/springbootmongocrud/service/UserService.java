package com.example.springbootmongocrud.service;

import java.util.List;

import com.example.springbootmongocrud.entity.User;

public interface UserService {

	public User saveUser(User user);

	public List<User> getUsers();

	public User updateUser(Long id, User user);

	public void deleteUser(Long id);
}
