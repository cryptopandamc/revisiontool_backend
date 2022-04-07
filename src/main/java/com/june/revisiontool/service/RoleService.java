package com.june.revisiontool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.june.revisiontool.model.Role;
import com.june.revisiontool.repository.RoleDao;

@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;

	public List<Role> retrieveAll() {
		return roleDao.findAll();
	}

	public Role findByName(String name) {
		return roleDao.findByName(name);
	}

}
