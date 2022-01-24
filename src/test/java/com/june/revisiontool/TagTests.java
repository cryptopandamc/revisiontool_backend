package com.june.revisiontool;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.june.revisiontool.model.Tag;
import com.june.revisiontool.service.TagService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class TagTests {

	@Autowired
	private TagService tagService;

	@Test
	void test_ThatAListOfAllTagsCanBeRetrieved() {
		List<Tag> allTags = tagService.retrieveAll();
		assertFalse(allTags.isEmpty());
	}

}
