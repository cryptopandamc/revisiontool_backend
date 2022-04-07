package com.june.revisiontool;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.june.revisiontool.model.Role;
import com.june.revisiontool.service.RoleService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class RoleTest {

	@Autowired
	private RoleService roleService;
	
	@Test
	void test_thatAListOfRolesCanBeRetrieved() {
		List<Role> allRoles = roleService.retrieveAll();
		assertFalse(allRoles.isEmpty());
	}
	
	@Test
	void test_thatARoleCanBeRetrievedUsingTheName() {
		String name = "Trainer";
		Role role = roleService.findByName(name);
		System.err.println(role);
		assertFalse(role.getRoleId() == 0);
	}
	
}
