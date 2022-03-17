package com.june.revisiontool.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.june.revisiontool.model.Question;
import com.june.revisiontool.model.Tag;
import com.june.revisiontool.service.QuestionService;

@RestController
@RequestMapping("/api/v1/question/")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionAPI {

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
		if (question.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(question.get());
	}

	@PostMapping("CreateQuestion")
	public ResponseEntity<HttpStatus> createQuestion(@Valid @RequestBody Question question,
			BindingResult bindingResult) {
		if (!questionService.create(question)) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@PutMapping("UpdateQuestion/{questionId}")
	public ResponseEntity<Question> updateQuestin(@PathVariable("questionId") long questionId,
			@RequestBody Question question) {
		if (questionService.update(question)) {
			return ResponseEntity.ok(question);
		}
		return ResponseEntity.notFound().build();
	}

	
	@GetMapping("GetByTag")
	public ResponseEntity<List<Question>> questionsByTag(Long tagId){
		List<Question> questionByTag = questionService.findByTagId(tagId);
		return ResponseEntity.ok(questionByTag);
	}
}
