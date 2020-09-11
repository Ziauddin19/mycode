package com.healthcare.enrollee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.enrollee.model.Enrollee;

@Repository
public interface EnrolleeRepository extends CrudRepository<Enrollee, Long> {

	Enrollee findById(long id);
	void deleteById(long id);
	/* void update(Enrollee enrollee); */
}
