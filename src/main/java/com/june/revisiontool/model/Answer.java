package com.june.revisiontool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_gen")
	@SequenceGenerator(name = "answer_gen", sequenceName = "ANSWER_SEQ", allocationSize = 1)
	private long answerId;

	@Column
	private String answerText;

	public Answer(String answerText) {
		super();
		this.answerText = answerText;
	}

	public Answer() {
		super();
	}

	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (answerId ^ (answerId >>> 32));
		result = prime * result + ((answerText == null) ? 0 : answerText.hashCode());
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
		Answer other = (Answer) obj;
		if (answerId != other.answerId)
			return false;
		if (answerText == null) {
			if (other.answerText != null)
				return false;
		} else if (!answerText.equals(other.answerText))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answerText=" + answerText + "]";
	}

}
