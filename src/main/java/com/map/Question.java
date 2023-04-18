package com.map;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity

public class Question {

	@Id
	@Column(name = "question_id")
	private int questionId;
	private String question;

//	@OneToOne
//	@JoinColumn(name="a_id")
//	private Answer answer;
//	

//	many to one
	@OneToMany(mappedBy="question")
	private List<Answer> answers;

	
	public Question(int questionId, String question, List<Answer> answers) {
	super();
	this.questionId = questionId;
	this.question = question;
	this.answers = answers;
}


	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

//	// one to one
//	public Answer getAnswer() {
//		return Answer;
//	}
//	public void setAnswer(Answer answer) {
//		this.answer = answer;
//	}
//	public Question(int questionId, String question, Answer answer) {
//		super();
//		this.questionId = questionId;
//		this.question = question;
//		this.answer = answer;
//	}

}
