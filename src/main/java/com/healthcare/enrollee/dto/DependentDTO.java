package com.healthcare.enrollee.dto;

public class DependentDTO {
	
    private Long id;
	private String name;
	private String dateOfBirth;
	private Long enrolleeId;
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
	public Long getEnrolleeId() {
		return enrolleeId;
	}
	public void setEnrolleeId(Long enrolleeId) {
		this.enrolleeId = enrolleeId;
	}
}
