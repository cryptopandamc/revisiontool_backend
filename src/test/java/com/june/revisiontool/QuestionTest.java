package com.june.revisiontool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.june.revisiontool.model.Answer;
import com.june.revisiontool.model.Question;
import com.june.revisiontool.model.Tag;
import com.june.revisiontool.service.QuestionService;
import com.june.revisiontool.service.TagService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class QuestionTest {
	
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private TagService tagService;
	
	private List<Answer> answers;
	private List<Question> questions;
	
	@BeforeEach
	void init() {
		answers = new ArrayList<>();
		questions = new ArrayList<>();	
	}
	

	@Test
	void test_thatAQuestionCanBePersisted() {	
		Question question = new Question("This is a question", answers, "C", false);
		boolean created = questionService.create(question);
		assertTrue(created);
	}
	
	@Test
	void test_ThatAQuestionCanBeRetrievedUsingTheId() {
		Question questionFromDb = questionService.retrieveOne(1).get();
		assertEquals(1, questionFromDb.getQuestionId());
	}
	
	@Test
	void test_ThatAListOfQuestionsCanBeRetrieved() {
		questions = questionService.retrieveAll();
		assertFalse(questions.isEmpty());
	}

	@Test
	void test_ThatAQuestionCanBeUpdated() {
		Question questionToUpdate = questionService.retrieveOne(1).get();
		questionToUpdate.setCorrectAnswer("D");
		assertNotEquals("B", questionToUpdate.getCorrectAnswer());
	}
	
	@Test
	void test_thatASetOfAnswersCanBeRetrieved_ForAQuestion() {
		Question question = questionService.retrieveOne(1).get();
		assertEquals(4, question.getAnswers().size());
	}
	
	@Test
	void test_thatAQuestionCanBeApprovedAfterItIsSubmitted() {
		Question question = questionService.retrieveOne(1).get();
		question.setApproved(true);
		questionService.update(question);
		boolean statusAfterChange = questionService.retrieveOne(1).get().isApproved();
		assertTrue( statusAfterChange);
	}
	
	@Test
	void test_thatTagsCanBePersisted() {
		Tag tag = new Tag("collections");
		tagService.create(tag);
		assertTrue(tag.getTagId() != 0);
	}
	
}
