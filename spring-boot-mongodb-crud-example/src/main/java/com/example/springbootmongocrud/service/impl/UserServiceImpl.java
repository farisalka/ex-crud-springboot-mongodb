package com.example.springbootmongocrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootmongocrud.entity.User;
import com.example.springbootmongocrud.repository.UserRepository;
import com.example.springbootmongocrud.service.UserService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(Long id, User user) {
		Optional<User> findById = userRepository.findById(id);
		if (findById.isPresent()) {
			User userEntity = findById.get();
			if (user.getName() != null && !user.getName().isEmpty())
				userEntity.setName(user.getName());
			if (user.getAge() != null)
				userEntity.setAge(user.getAge());
			if (user.getEmail() != null && !user.getEmail().isEmpty())
				userEntity.setEmail(user.getEmail());
			if (user.getAddress() != null && !user.getAddress().isEmpty())
				userEntity.setAddress(user.getAddress());
			return userRepository.save(userEntity);
		}
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
