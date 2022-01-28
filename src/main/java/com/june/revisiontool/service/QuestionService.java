package com.june.revisiontool.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.june.revisiontool.model.Answer;
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

	public Optional<Question> retrieveOne(long questionId) {
		return questionDao.findById(questionId);
	}

	public List<Question> retrieveAll() {
		return questionDao.findAll();
	}

	public boolean update(Question question) {
		if (retrieveOne(question.getQuestionId()).isPresent()) {
			questionDao.save(question);
			return true;
		}
		return false;
	}

	public void approveQuestion(Question question) {
		question.setApproved(true);
	}

	public List<Question> retrieveNotApproved() {
		return questionDao.retrieveNotApproved();
	}

}
