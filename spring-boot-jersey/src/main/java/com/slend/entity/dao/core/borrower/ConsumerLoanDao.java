package com.slend.entity.dao.core.borrower;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slend.entity.core.borrower.CarLoan;
import com.slend.entity.core.borrower.ConsumerLoan;
@Repository
public interface ConsumerLoanDao extends CrudRepository<ConsumerLoan, Integer>{

}
