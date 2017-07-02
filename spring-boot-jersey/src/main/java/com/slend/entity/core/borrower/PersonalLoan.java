package com.slend.entity.core.borrower;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sl_personalloan")
public class PersonalLoan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private LoanReason loanReason;

	public PersonalLoan() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LoanReason getLoanReason() {
		return loanReason;
	}

	public void setLoanReason(LoanReason loanReason) {
		this.loanReason = loanReason;
	}

}
