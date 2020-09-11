package com.healthcare.enrollee.service;

import com.healthcare.enrollee.dto.DependentDTO;
import com.healthcare.enrollee.dto.EnrolleeDTO;

public interface EnrolleeService {
	public void addEnrollee(EnrolleeDTO dto);
	public void addDependentToEnrollee(DependentDTO dependentDTO);
	public EnrolleeDTO updateEnrollee(EnrolleeDTO enrolleeDTO);
	public DependentDTO updateDependent(DependentDTO dependentDTO);
	public void deleteDependents(DependentDTO dependentDTO);
	public void deleteEnrollee(EnrolleeDTO enrolleeDTO);
}
