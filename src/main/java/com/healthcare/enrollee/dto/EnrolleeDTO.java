package com.healthcare.enrollee.dto;

import java.util.List;

public class EnrolleeDTO {

	private Long id;
	private String name;
	private String dateOfBirth;
	private String phoneNumber;
	private boolean activationStatus;
	private List<DependentDTO> dependents;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public List<DependentDTO> getDependents() {
		return dependents;
	}
	public void setDependents(List<DependentDTO> dependents) {
		this.dependents = dependents;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isActivationStatus() {
		return activationStatus;
	}
	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

}
