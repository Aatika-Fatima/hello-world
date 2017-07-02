package com.slend.entity.dao.core.borrower;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slend.entity.core.borrower.ApplicantDetails;

@Repository
public interface ApplicantDetailsDao extends CrudRepository<ApplicantDetails, Long>{

}
