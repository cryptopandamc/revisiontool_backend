package com.june.revisiontool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.june.revisiontool.model.Question;
import com.june.revisiontool.repository.QuestionDao;

@Service
public class QuestionService {

	@Autowired
	private QuestionDao questionDao;

	public boolean create(Question question) {
		questionDao.save(question);
		return true;
	}

}
