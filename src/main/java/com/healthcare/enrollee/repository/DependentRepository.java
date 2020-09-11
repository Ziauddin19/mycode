package com.healthcare.enrollee.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.enrollee.model.Dependent;

@Repository
public interface DependentRepository extends CrudRepository<Dependent, Long> {

	List<Dependent> findByEnrolleeId(long enrolleeId);
	void deleteById(long id);
	Dependent findById(long id);
	/* void update(Dependent dependent); */
}
