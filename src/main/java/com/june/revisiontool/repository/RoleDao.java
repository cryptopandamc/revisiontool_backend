package com.june.revisiontool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.june.revisiontool.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

}
