package com.shritej.springsec.repository;

import com.shritej.springsec.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Integer> {
//    @PreAuthorize("hasRole('ROOT')")
    List<Loans> findByCustomerIdOrderByStartDtDesc(long id);
}
