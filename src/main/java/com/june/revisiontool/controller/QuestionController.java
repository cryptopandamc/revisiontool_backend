package com.june.revisiontool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
}
