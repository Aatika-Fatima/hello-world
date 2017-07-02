package com.slend.entity.core.borrower;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "s1_copApplicatnsDetails")
@Entity
public class CoApplicantDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
}
