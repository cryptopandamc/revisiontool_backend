package com.june.revisiontool.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.june.revisiontool.model.Answer;
import com.june.revisiontool.model.Question;
import com.june.revisiontool.service.QuestionService;
import com.june.revisiontool.service.TagService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private TagService tagService;

	
	@GetMapping("/AllQuestions")
	public ModelAndView allQuestions(ModelAndView modelAndView) {
		modelAndView.addObject("allQuestions", questionService.retrieveAll());
		return modelAndView;
	}

	@GetMapping("/AddQuestion")
	public ModelAndView addQuestion(ModelAndView modelAndView) {
		modelAndView.addObject("allTags", tagService.retrieveAll());
		modelAndView.setViewName("addQuestion");
		modelAndView.addObject("question", new Question());
		return modelAndView;
	}

	@PostMapping("/AddQuestionSubmit")
	public ModelAndView addQuestionSubmit(ModelAndView modelAndView, Question question) {
		questionService.create(question);
		System.err.println(question);
		modelAndView.addObject("allQuestions", questionService.retrieveAll());
		modelAndView.setViewName("allQuestions");
		return modelAndView;
	}

	@GetMapping("/EditQuestion/{questionId}")
	public ModelAndView editQuestion(@PathVariable("questionId") long questionId, ModelAndView modelAndView) {
		Optional<Question> question = questionService.retrieveOne(questionId);
		List<Answer> answers = question.get().getAnswers();
		AnswerWrapper answerWrapper = new AnswerWrapper();
		for (int i = 0	; i >= answers.size(); i++) {
			Answer answer = answers.get(i);
			answer.setAnswerId(answer.getAnswerId());
	        answerWrapper.addAnswer(answer, question.get());
	    }
		
		modelAndView.addObject("question", question.get());
		modelAndView.addObject("allTags", tagService.retrieveAll());
		modelAndView.addObject("answers", question.get().getAnswers());
		if (question.isPresent()) {
			modelAndView.setViewName("editQuestion");
			return modelAndView;
		}
		return modelAndView;
	}

	@PostMapping("/EditQuestionSubmit")
	public ModelAndView editQuestionSubmit(ModelAndView modelAndView, Question question) {
		if (questionService.update(question)) {
			System.err.println(question);
			modelAndView.addObject("allQuestions", questionService.retrieveAll());
			modelAndView.setViewName("allQuestions");
			return modelAndView;
		}
		modelAndView.setViewName("allQuestions");
		return modelAndView;
	}

}
