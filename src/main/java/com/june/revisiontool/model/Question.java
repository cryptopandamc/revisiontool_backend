package com.june.revisiontool.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_gen")
	@SequenceGenerator(name = "question_gen", sequenceName = "QUESTION_SEQ", allocationSize = 1)
	private long questionId;

	@Column
	private String questionText;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Answer> answers = new ArrayList<>();

	@Column
	private String correctAnswer;

	@Column
	private boolean approved;

	public Question(String questionText, List<Answer> answers, String correctAnswer, boolean approved) {
		super();
		this.questionText = questionText;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
		this.approved = approved;
	}

	public Question() {
		super();
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", answers=" + answers
				+ ", correctAnswer=" + correctAnswer + ", approved=" + approved + "]";
	}

}
