package com.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.api.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
