package com.example.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="QUESTION_ID", length=10)
	private int questionId; 
	
	@Column(name="QUESTION_TEXT", length=300, nullable=false, unique=true)
	private String questionText; 
	@Column(name="OPTION_A", length=300, nullable=false)
	private String optionA; 
	@Column(name="OPTION_B", length=300, nullable=false)
	private String optionB; 
	@Column(name="OPTION_C", length=300, nullable=false)
	private String optionC; 
	@Column(name="OPTION_D", length=300, nullable=false)
	private String optionD; 
	
	@Column(name="ANSWER", length=1, nullable=false)
	private String answer; 
	
	@ManyToOne
	@JoinColumn(name="AUTHOR_ID_FK")
	Author author;
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	Category category; 
	@ManyToOne
	@JoinColumn(name="DIFFICULTY_ID")
	DifficultyLevel difficultyLevel;
	public Question(String questionText, String optionA, String optionB, String optionC, String optionD, String answer,
			Author author, Category category, DifficultyLevel difficultyLevel) {
		super();
		this.questionText = questionText;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.author = author;
		this.category = category;
		this.difficultyLevel = difficultyLevel;
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
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	} 
	
	
}
