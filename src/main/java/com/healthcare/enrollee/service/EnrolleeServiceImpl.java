package com.healthcare.enrollee.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.enrollee.dto.DependentDTO;
import com.healthcare.enrollee.dto.EnrolleeDTO;
import com.healthcare.enrollee.model.Dependent;
import com.healthcare.enrollee.model.Enrollee;
import com.healthcare.enrollee.repository.DependentRepository;
import com.healthcare.enrollee.repository.EnrolleeRepository;

@Service
public class EnrolleeServiceImpl implements EnrolleeService {

	@Autowired
	private DependentRepository dependentRepository;
	@Autowired
	private EnrolleeRepository enrolleeRepository;
	@Override
	public void addEnrollee(EnrolleeDTO dto) {
		
		Enrollee enrollee=getEnrollee(dto);
		enrolleeRepository.save(enrollee);
		for(Dependent dependent:enrollee.getDependents()) {
			dependent.setEnrollee(enrollee);
			dependentRepository.save(dependent);
		}
		
	}
	private Enrollee getEnrollee(EnrolleeDTO dto) {
		Enrollee enrollee= new Enrollee();
		enrollee.setActivationStatus(dto.isActivationStatus());
		enrollee.setDateOfBirth(convertDate(dto.getDateOfBirth()));
		enrollee.setId(dto.getId());
		enrollee.setName(dto.getName());
		enrollee.setPhoneNumber(dto.getPhoneNumber());
		enrollee.setDependents(getDependents(dto.getDependents()));
		return enrollee;
	}
	private Date convertDate(String dateOfBirth) {
		Date date1=null;
		 try {
			 date1=new SimpleDateFormat("dd-MM-yyyy").parse(dateOfBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return date1;
	}
	private List<Dependent> getDependents(List<DependentDTO> dependents) {
		
		List<Dependent> list= new ArrayList<Dependent>();
		dependents.forEach(dto->{
			Dependent dependent = getDependent(dto);
			list.add(dependent);
		});
		return list;
	}
	private Dependent getDependent(DependentDTO dto) {
		Dependent dependent= new Dependent();
		dependent.setDateOfBirth(convertDate(dto.getDateOfBirth()));
		dependent.setId(dto.getId());
		dependent.setName(dto.getName());
		return dependent;
	}
	@Override
	public void addDependentToEnrollee(DependentDTO dependentDTO) {
		
		Enrollee enrollee=enrolleeRepository.findById(dependentDTO.getEnrolleeId()).get();
		
		Dependent dependent=getDependent(dependentDTO);
		dependent.setEnrollee(enrollee);
		dependentRepository.save(dependent);
	}
	@Override
	public EnrolleeDTO updateEnrollee(EnrolleeDTO enrolleeDTO) {
		Enrollee enrollee=enrolleeRepository.findById(enrolleeDTO.getId()).get();
		enrollee.setActivationStatus(enrollee.isActivationStatus());
		enrollee.setDateOfBirth(convertDate(enrolleeDTO.getDateOfBirth()));
		enrollee.setPhoneNumber(enrolleeDTO.getPhoneNumber());
		enrollee.setName(enrolleeDTO.getName());
		enrollee.setDependents(getDependents(enrolleeDTO.getDependents()));
		enrollee= enrolleeRepository.save(enrollee);
		return getEnrolleeDTO(enrollee);
	}
	private EnrolleeDTO getEnrolleeDTO(Enrollee enrollee) {
		EnrolleeDTO dto = new EnrolleeDTO();
		dto.setActivationStatus(enrollee.isActivationStatus());
		dto.setDateOfBirth(convertDateToString(enrollee.getDateOfBirth()));
		dto.setName(enrollee.getName());
		dto.setPhoneNumber(enrollee.getPhoneNumber());
		dto.setDependents(getDependentDTOs(enrollee.getDependents()));
		return dto;
	}
	private List<DependentDTO> getDependentDTOs(List<Dependent> dependents) {
		
		List<DependentDTO> list= new ArrayList<DependentDTO>();
		dependents.forEach(dependent->{
			DependentDTO dto= getDependentDTO(dependent);
			list.add(dto);
		});
		return list;
	}
	private DependentDTO getDependentDTO(Dependent dependent) {
		DependentDTO dto= new DependentDTO();
		dto.setDateOfBirth(convertDateToString(dependent.getDateOfBirth()));
		dto.setName(dependent.getName());
		dto.setId(dependent.getId());
		return dto;
	}
	private String convertDateToString(Date dateOfBirth) {
		
		SimpleDateFormat sdfr = new SimpleDateFormat("dd-MMM-yyyy");
		
		return sdfr.format(dateOfBirth);
	}
	@Override
	public DependentDTO updateDependent(DependentDTO dependentDTO) {
		Dependent dependent=dependentRepository.findById(dependentDTO.getId()).get();
		dependent.setDateOfBirth(convertDate(dependentDTO.getDateOfBirth()));
		dependent.setName(dependentDTO.getName());
		dependent=dependentRepository.save(dependent);
		return getDependentDTO(dependent);
	}
	@Override
	public void deleteDependents(DependentDTO dependentDTO) {
		dependentRepository.deleteById(dependentDTO.getId());
		
	}
	@Override
	public void deleteEnrollee(EnrolleeDTO enrolleeDTO) {
		enrolleeRepository.deleteById(enrolleeDTO.getId());
	}

	

}
