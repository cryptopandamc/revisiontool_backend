package com.june.revisiontool.controller;

import java.util.List;

import com.june.revisiontool.model.Answer;
import com.june.revisiontool.model.Question;

public class AnswerWrapper {

	private List<Answer> answers;

	public void addAnswer(Answer answer, Question question) {
		int index = (int) question.getQuestionId();
		answers = question.getAnswers();
		this.answers.add(index, answer);
	}

}
