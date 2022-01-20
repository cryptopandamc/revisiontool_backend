package com.june.revisiontool.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.june.revisiontool.model.Question;
import com.june.revisiontool.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/AllQuestions")
	public ModelAndView allQuestions(ModelAndView modelAndView) {
		 List<Question> questions = questionService.retrieveAll();
		modelAndView.addObject("allQuestions", questionService.retrieveAll());
		modelAndView.addObject("question");
		return modelAndView;
	}
}
