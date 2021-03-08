package com.Perficient.employee.demoapp.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.Perficient.employee.demoapp.model.Skill;
import com.Perficient.employee.demoapp.model.SkillDAO;

@RestController
@CrossOrigin
public class SkillController {
	@Autowired
	SkillDAO dao;
	
	@RequestMapping(path = "/employees/{employeeId}/skills", method = RequestMethod.GET)
	public ResponseEntity<List<Skill>> getAllSkills() {
		List<Skill> listOfEmployees = dao.getAllSkills();
		if (listOfEmployees.isEmpty()) {
			System.out.println("Invalid request.");
			return new ResponseEntity<List<Skill>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Skill>>(listOfEmployees, HttpStatus.OK);
	}
	
	@RequestMapping(path = "​/employees​/{employeeId}​/skills​/{skillId}", method = RequestMethod.GET)
	public ResponseEntity<Skill> getTechnicalSkillByEmployeeId(@Valid @PathVariable String employeeId) {
		Skill employeeIdz = dao.getTechnicalSkillByEmployeeId(employeeId);
		if (employeeIdz == null) {	
			System.out.println("Ope, That Id Doesn't Exist.");
			return new ResponseEntity<Skill>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Skill>(employeeIdz, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/employees/{employeeId}/skills", method = RequestMethod.POST)
	public ResponseEntity<?> addSkill(@Valid @RequestBody Skill employeeId) {
		Skill addSkill = (Skill) dao.getAllSkills();
		if (addSkill == null) {
			dao.addSkill(employeeId);
		} else {
			System.out.println("Ope, This Employee Already Exists");
			return new ResponseEntity<Skill>(HttpStatus.IM_USED);
		}
		return new ResponseEntity<Skill>(addSkill, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/employees/{employeeId}/skills/{skillId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateSkill(@Valid @RequestBody String employeeId) {
		Skill updatedSkill = dao.getTechnicalSkillByEmployeeId(employeeId);
		if (updatedSkill != null) {
			dao.updateSkill(employeeId);
		} else {
			System.out.println("Ope, Invalid Id. Enter A Valid Id");
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "​/employees​/{employeeId}​/skills​/{skillId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteSkillById(@PathVariable String employeeId) {
		Skill deletedFood = dao.getTechnicalSkillByEmployeeId(employeeId);
		if (deletedFood != null) {
			dao.deleteSkillById(employeeId);
		} else {
			System.out.println("Ope, This Id Is Not Valid To Delete. Enter A Valid Id");
			return new ResponseEntity<Skill>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Skill>(HttpStatus.OK);
	}
	
	
}
