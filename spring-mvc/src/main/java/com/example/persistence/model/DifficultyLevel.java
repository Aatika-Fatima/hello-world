package com.example.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="DIFFICULTY_LEVEL")
public class DifficultyLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DIFFICULTY_ID", length = 2)
	private int difficultyId;
	@Column(name = "DIFFICULTY_NAME", length = 25, nullable = false, unique=true)
	private String difficultyName;
	public int getDifficultyId() {
		return difficultyId;
	}
	public void setDifficultyId(int difficultyId) {
		this.difficultyId = difficultyId;
	}
	public String getDifficultyName() {
		return difficultyName;
	}
	public void setDifficultyName(String difficultyName) {
		this.difficultyName = difficultyName;
	}
	public DifficultyLevel(int difficultyId, String difficultyName) {
		super();
		this.difficultyId = difficultyId;
		this.difficultyName = difficultyName;
	}
	public DifficultyLevel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
