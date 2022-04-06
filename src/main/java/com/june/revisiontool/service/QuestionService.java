package com.june.revisiontool.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.revisiontool.model.Question;
import com.june.revisiontool.model.Tag;
import com.june.revisiontool.repository.QuestionDao;

@Service
public class QuestionService {
	
	private final static Logger LOGGER = LogManager.getLogger(QuestionService.class);
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private EntityManager em;

	@Transactional
	public boolean create(Question question) {
		LOGGER.info("Question is {}", question);
		List<Tag> retrievedTags = new ArrayList<>();
		for (Tag tag : question.getTags()) {
			retrievedTags.add(tagService.retrieveOne(tag.getTagId()).get());
		}
		question.setTags(retrievedTags);
		questionDao.save(question);
		if (question.getQuestionId() != 0) {
			return true;
		}
		LOGGER.error("ERR: Question not saved");
		return false;
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

	public boolean approveQuestion(Question question) {
		if (retrieveOne(question.getQuestionId()).isPresent()) {
			question.setApproved(true);
			update(question);
			return true;
		}
		return false;
	}

	public List<Question> retrieveNotApproved() {
		return questionDao.retrieveNotApproved();
	}

	public List<Question> retrieveByTag(Tag tag) {
		return questionDao.getByTags(tag);
	}

	public List<Question> findByTagId(long tagId) {
		return questionDao.findByTagId(tagId);
	}

}