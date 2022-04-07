package com.june.revisiontool;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.june.revisiontool.model.Role;
import com.june.revisiontool.model.User;
import com.june.revisiontool.service.RoleService;
import com.june.revisiontool.service.UserService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserTest {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	private List<Role> roles = new ArrayList<>();
	
	@Test
	void test_thatAUserCanBeFoundWithTheirUserName() {
		User user = userService.findByName("June");
		assertTrue(user.getUserId() != 0);
	}
	
	
	@Test
	void test_ThatAUserCanBeCreated() {
		Role role = roleService.findByName("Trainee");
		roles.add(role);
		User user = new User("test", "test@test.com", roles, "testpassword");
		userService.create(user);
	}
}
