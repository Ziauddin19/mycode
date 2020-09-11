package com.healthcare.enrollee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Dependent {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "dependent_Sequence")
	@SequenceGenerator(name = "dependent_Sequence", sequenceName = "DEPENDENT_SEQ")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "dateOfbirth")
	private Date dateOfBirth;


	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enrollee_id", nullable = true)
    private Enrollee enrollee;
	
	public Dependent() {
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Enrollee getEnrollee() {
		return enrollee;
	}

	public void setEnrollee(Enrollee enrollee) {
		this.enrollee = enrollee;
	}
		
}
