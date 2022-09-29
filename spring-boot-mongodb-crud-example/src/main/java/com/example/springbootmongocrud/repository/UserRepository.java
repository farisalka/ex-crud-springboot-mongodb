package com.example.springbootmongocrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springbootmongocrud.entity.User;

public interface UserRepository extends MongoRepository<User, Long> {

}
