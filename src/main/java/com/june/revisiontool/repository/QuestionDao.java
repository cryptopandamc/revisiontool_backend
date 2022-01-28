package com.june.revisiontool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.june.revisiontool.model.Question;

public interface QuestionDao extends JpaRepository <Question, Long> {

	@Query(value ="Select q from Question q where q.approved  = false")
	List<Question> retrieveNotApproved();


}
