package com.june.revisiontool;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.june.revisiontool.model.User;
import com.june.revisiontool.service.UserService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserTest {

	
	@Autowired
	private UserService userService;
	
	@Test
	void test_thatAUserCanBeFoundWithTheirUserName() {
		User user = userService.findByName("June");
		assertTrue(user.getUserId() != 0);
	}
}
