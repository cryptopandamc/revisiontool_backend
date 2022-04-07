package com.june.revisiontool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.june.revisiontool.model.User;

public interface UserDao extends JpaRepository<User, Long> {

	User findByName(String name);

}
