package com.slend.entity.dao.core.borrower;

import org.springframework.data.repository.CrudRepository;

import com.slend.entity.core.borrower.HomeLoan;

public interface PersonalLoanDao extends CrudRepository<HomeLoan, Long>{

}
