package com.june.revisiontool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.june.revisiontool.model.Question;
import com.june.revisiontool.service.QuestionService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class QuestionTest {
	
	
	@Autowired
	private QuestionService questionService;
	
	Map<String, String> answers;
	
	@BeforeEach
	void init() {
		answers = new HashMap<>();
	}
	

	@Test
	void test_thatAQuestionCanBePersisted() {
		answers.put("A", "Answer one");
		answers.put("B", "Answer two");
		answers.put("C", "Answer three");
		answers.put("D", "Answer four");
		Question question = new Question("This is a question", answers, "B");
		boolean created = questionService.create(question);
		assertTrue(created);
	}
	
	@Test
	void test_ThatAQuestionCanBeRetrievedUsingTheId() {
		Question questionFromDb = questionService.retrieveOne(1).get();
		assertEquals(1, questionFromDb.getQuestionId());
	}
	
	

}
