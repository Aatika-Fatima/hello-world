package com.slend.entity.dao.core.borrower;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slend.entity.core.borrower.HomeLoan;

@Repository
public interface HomeLoanDao extends CrudRepository<HomeLoan, Long>{

}
