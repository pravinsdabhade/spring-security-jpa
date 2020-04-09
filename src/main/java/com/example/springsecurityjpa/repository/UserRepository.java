package com.example.springsecurityjpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.springsecurityjpa.entity.User;

public interface UserRepository extends JpaRepositoryImplementation<User, Integer> {

	Optional<User> findByUserName(String userName);
}
