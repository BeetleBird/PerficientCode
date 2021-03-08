package com.Perficient.employee.demoapp.model;

import java.util.List;

import javax.validation.Valid;

public interface EmployeeDAO {

	public List<Employee> getAllEmployees();

	public List<Employee> getEmployeesById(String employeeId);

	public void addEmployee(Employee employee);

	public void updateEmployee(List<Employee> updatedEmployee);

	public void deleteEmployeesById(String employeeId);

}