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

import com.Perficient.employee.demoapp.model.Address;
import com.Perficient.employee.demoapp.model.Employee;
import com.Perficient.employee.demoapp.model.EmployeeDAO;
import com.Perficient.employee.demoapp.model.Field;
import com.Perficient.employee.demoapp.model.Skill;

@RestController
@CrossOrigin
public class EmployeeController {
	@Autowired
	private EmployeeDAO dao;
	
	
	@RequestMapping(path = "/employees", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> listOfEmployees = dao.getAllEmployees();
		if (listOfEmployees.isEmpty()) {
			System.out.println("Invalid request.");
			return new ResponseEntity<List<Employee>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Employee>>(listOfEmployees, HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "/employees{employeeId}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployeesById(@Valid @PathVariable String employeeId) {
		List<Employee> employeeIdz = dao.getEmployeesById(employeeId);
		if (employeeIdz.isEmpty()) {
			System.out.println("Ope, That Id Doesn't Exist.");
			return new ResponseEntity<List<Employee>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Employee>>(employeeIdz, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/addEmployee", method = RequestMethod.POST)
	public ResponseEntity<?> addEmployee(@Valid @RequestBody String employee) {
		Employee addEmployee = (Employee) dao.getEmployeesById(employee);
		if (addEmployee == null) {
			dao.addEmployee(addEmployee);
		} else {
			System.out.println("Ope, This Food Already Exists");
			return new ResponseEntity<Employee>(HttpStatus.IM_USED);
		}
		return new ResponseEntity<Employee>(addEmployee, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/employees/{employeeId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmployee(@Valid @RequestBody String employeeId) {
		Employee updatedEmployee = dao.getEmployeesById(employeeId);
		if (updatedEmployee != null) {
			dao.updateEmployee(updatedEmployee);
		} else {
			System.out.println("Ope, Invalid Id. Enter A Valid Id");
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/employees/{employeeId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployeesById(@PathVariable String employeeId) {
		Employee deletedEmployee = dao.getEmployeesById(employeeId);
		if (deletedEmployee != null) {
			dao.deleteEmployeesById(employeeId);
		} else {
			System.out.println("Ope, This Id Is Not Valid To Delete. Enter A Valid Id");
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
}
