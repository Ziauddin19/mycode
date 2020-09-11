package com.healthcare.enrollee.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Enrollee {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "enrollee_Sequence")
	@SequenceGenerator(name = "enrollee_Sequence", sequenceName = "ENROLLEE_SEQ")
	private Long id;

	@Column(name = "name")
	private String name;
    
	@Column(name="activationStatus")
	private boolean activationStatus;
	
	@Column(name="dateOfBirth")
	private Date dateOfBirth;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "enrollee")
	private List<Dependent> dependents;
	
	public Enrollee() {
	}

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

	public boolean isActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


}
