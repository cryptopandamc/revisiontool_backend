package com.june.revisiontool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.june.revisiontool.model.Question;

public interface QuestionDao extends JpaRepository <Question, Long> {

}
