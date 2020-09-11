package com.healthcare.enrollee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.enrollee.dto.DependentDTO;
import com.healthcare.enrollee.dto.EnrolleeDTO;
import com.healthcare.enrollee.service.EnrolleeService;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class EnrolleeController {
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
	
	@Autowired
	EnrolleeService  service;
	
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    
   }
    
    @RequestMapping(value="/addEnrollee",method = RequestMethod.POST)
    @ResponseBody
    public  ResponseEntity<String> createEnrollee(@RequestBody EnrolleeDTO dto) {
    	try{
    		service.addEnrollee(dto);
    	}catch (Exception e) {
    		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
    	return new ResponseEntity<>("Enrollee created",HttpStatus.ACCEPTED);
   }
    
    @RequestMapping(value="/updateEnrollee",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<EnrolleeDTO>   updateEnrollee(@RequestBody EnrolleeDTO dto) {
    	EnrolleeDTO enrolleeDTO=null;
    	try{
     		 enrolleeDTO=service.updateEnrollee(dto);
     	}catch (Exception e) {
     		return new ResponseEntity<EnrolleeDTO>(HttpStatus.EXPECTATION_FAILED);
 		}
     	return new ResponseEntity<>(enrolleeDTO,HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(value="/deleteEnrollee",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String>  deleteEnrollee(@RequestBody EnrolleeDTO dto) {
     	try{
     		service.deleteEnrollee(dto);
     	}catch (Exception e) {
     		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
 		}
     	return new ResponseEntity<>("Enrollee deleted ",HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(value="/addDependent",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String>  addDependentToEnrollee(@RequestBody DependentDTO dependentDTO) {
     	try{
     		service.addDependentToEnrollee(dependentDTO);
     	}catch (Exception e) {
     		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
 		}
     	return new ResponseEntity<>("dependent created ",HttpStatus.EXPECTATION_FAILED);
    }
    
    @RequestMapping(value="/updateDependent",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<DependentDTO> updateDependentToEnrollee(@RequestBody DependentDTO dependentDTO) {
    	DependentDTO depDto=null;
    	try{
     		 depDto=service.updateDependent(dependentDTO);
     	}catch (Exception e) {
     		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
 		}
    	return new ResponseEntity<DependentDTO>(depDto,HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(value="/deleteDependent",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> deleteDependent(@RequestBody DependentDTO dependentDTO) {
     	try{
     		service.deleteDependents(dependentDTO);
     	}catch (Exception e) {
     		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
 		}
     	return new ResponseEntity<>("dependent deleted ",HttpStatus.EXPECTATION_FAILED);
    }
}
