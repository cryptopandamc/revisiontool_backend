package com.june.revisiontool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.june.revisiontool.model.Answer;
import com.june.revisiontool.model.Question;
import com.june.revisiontool.model.Tag;

public interface QuestionDao extends JpaRepository<Question, Long> {

	@Query(value = "Select q from Question q where q.approved  = false")
	List<Question> retrieveNotApproved();

	List<Question> getByTags(Tag tag);

	@Query  (value = "select q from Question q inner join q.tags t where t.tagId = :tagId") 
	List<Question> findByTagId(Long tagId);

}
