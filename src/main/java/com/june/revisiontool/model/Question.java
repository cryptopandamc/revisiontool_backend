package com.june.revisiontool.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_gen")
	@SequenceGenerator(name = "question_gen", sequenceName = "QUESTION_SEQ", allocationSize = 1)
	private long questionId;

	@Column
	private String questionText;

	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Answer> answers = new ArrayList<>();

	@Enumerated(EnumType.STRING)
	private CorrectAnswer correctAnswer;

	@Column
	private boolean approved;

	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Tag> tags;

	

	public Question(String questionText, List<Answer> answers, CorrectAnswer correctAnswer, boolean approved,
			List<Tag> tags) {
		super();
		this.questionText = questionText;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
		this.approved = approved;
		this.tags = tags;
	}

	//@JsonCreator maybe need another constructor here
	
	public Question() {
	}

	public boolean addAnswer(Answer answer) {
		return answers.add(answer);
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

	

	public CorrectAnswer getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(CorrectAnswer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + ((correctAnswer == null) ? 0 : correctAnswer.hashCode());
		result = prime * result + (int) (questionId ^ (questionId >>> 32));
		result = prime * result + ((questionText == null) ? 0 : questionText.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (approved != other.approved)
			return false;
		if (correctAnswer != other.correctAnswer)
			return false;
		if (questionId != other.questionId)
			return false;
		if (questionText == null) {
			if (other.questionText != null)
				return false;
		} else if (!questionText.equals(other.questionText))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", answers=" + answers
				+ ", correctAnswer=" + correctAnswer + ", approved=" + approved + ", tags=" + tags + "]";
	}

}
