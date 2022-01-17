package com.june.revisiontool.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.june.revisiontool.model.Question;
import com.june.revisiontool.service.QuestionService;

@RestController
@RequestMapping("/api/v1/question/")
@CrossOrigin(origins = "http://localhost:3000")
public class RestApi {

	@Autowired
	private QuestionService questionService;

	@GetMapping("AllQuestions")
	public ResponseEntity<List<Question>> allQuestions() {
		List<Question> allQuestions = questionService.retrieveAll();
		return ResponseEntity.ok(allQuestions);
	}

	@GetMapping("Question/{questionId}")
	public ResponseEntity<Question> question(@PathVariable("questionId") long questionId) {
		Optional<Question> question = questionService.retrieveOne(questionId);
		if(question.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(question.get());
	}
}
