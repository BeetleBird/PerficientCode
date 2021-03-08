package com.Perficient.employee.demoapp.model.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.Perficient.employee.demoapp.model.Address;
import com.Perficient.employee.demoapp.model.Employee;
import com.Perficient.employee.demoapp.model.EmployeeDAO;
import com.Perficient.employee.demoapp.model.Field;
import com.Perficient.employee.demoapp.model.Skill;

@Component
public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = new ArrayList<>();
		String sql = "SELECT employees.employees_uid, employees.first_name, employees.address_uid, employees.last_name, employees.company_email, employees.birth_date, employees.hire_date, employees.role, "
				+ "address.address_uid, address.street, address.city, address.region, address.postal, address.country, "
				+ "skill.skill_uid, skill.field_uid, skill.experience, field.field_uid, field.name, field.type "
				+ "FROM employees " + "LEFT JOIN address ON employees.address_uid = address.address_uid "
				+ "LEFT JOIN skill ON employees_uid = skill.skill_uid "
				+ "LEFT JOIN field ON skill.field_uid = field.field_uid; ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while (results.next()) {
			String id = results.getString("employees_uid");
			String firstName = results.getString("first_name");
			String lastName = results.getString("last_name");
			String companyEmail = results.getString("company_email");
			String birthDay = results.getString("birth_date");
			String hiredDate = results.getString("hire_date");
			String role = results.getString("role");

			String address_uid = results.getString("address_uid");
			String street = results.getString("street");
			String city = results.getString("city");
			String region = results.getString("region");
			String postal = results.getString("postal");
			String country = results.getString("country");
			Address address = new Address(address_uid, street, city, region, postal, country);

			String skillUid = results.getString("skill_uid");
			int experience = results.getInt("experience");
			Skill skill = new Skill(skillUid, experience);

			String fieldUid2 = results.getString("field_uid");
			String name = results.getString("name");
			String type = results.getString("type");
			Field field = new Field(fieldUid2, name, type);

			Employee anotherEmployee = new Employee(id, firstName, lastName, address, companyEmail, birthDay, hiredDate,
					role, skill, field);
			allEmployees.add(anotherEmployee);

		}

		return allEmployees;
	}

	@Override
	public List<Employee> getEmployeesById(String employeeId) {
		List<Employee> allEmployees = new ArrayList<>();
		String sql = "SELECT employees.employees_uid, employees.first_name, employees.address_uid, employees.last_name, employees.company_email, employees.birth_date, employees.hire_date, employees.role, "
				+ "address.address_uid, address.street, address.city, address.region, address.postal, address.country, "
				+ "skill.skill_uid, skill.field_uid, skill.experience, field.field_uid, field.name, field.type "
				+ "FROM employees " + "LEFT JOIN address ON employees.address_uid = address.address_uid "
				+ "LEFT JOIN skill ON employees_uid = skill.skill_uid "
				+ "LEFT JOIN field ON skill.field_uid = field.field_uid " + "WHERE employees.employees_uid = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, employeeId);
		Employee employee = null;

		while (results.next()) {
			String id = results.getString("employees_uid");
			String firstName = results.getString("first_name");
			String lastName = results.getString("last_name");
			String companyEmail = results.getString("company_email");
			String birthDay = results.getString("birth_date");
			String hiredDate = results.getString("hire_date");
			String role = results.getString("role");

			String address_uid = results.getString("address_uid");
			String street = results.getString("street");
			String city = results.getString("city");
			String region = results.getString("region");
			String postal = results.getString("postal");
			String country = results.getString("country");
			Address address = new Address(address_uid, street, city, region, postal, country);

			String skillUid = results.getString("skill_uid");
			int experience = results.getInt("experience");

			Skill skill = new Skill(skillUid, experience);

			String fieldUid2 = results.getString("field_uid");
			String name = results.getString("name");
			String type = results.getString("type");

			Field field = new Field(fieldUid2, name, type);

//			UUID uid = UUID.fromString(employeeId);

			Employee anotherEmployee = new Employee(id, firstName, lastName, address, companyEmail, birthDay, hiredDate,
					role, skill, field);
			allEmployees.add(anotherEmployee);

		}

		return allEmployees;


	}

	@Override
	public void addEmployee(Employee employee) {

		String sql = "INSERT INTO address (street, city, region, postal, country) " + "VALUES (?, ?, ?, ?, ?); "
				+ "INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role) "
				+ "VALUES (?, ?, (SELECT address_uid from address  ORDER BY " + "stamp "
				+ " DESC LIMIT 1), ?, ?, ?, ?); " + "INSERT INTO field (name, type) VALUES (?, ?); "
				+ "INSERT INTO skill (skill_uid, field_uid, experience) "
				+ "VALUES ((SELECT employees_uid from employees ORDER BY " + "stamp "
				+ " DESC LIMIT 1), ( SELECT field_uid from field ORDER BY " + "stamp " + " DESC LIMIT 1), ?);";

		jdbcTemplate.update(sql);
	}

	@Override
	public void updateEmployee(List<Employee> employee) {
		String sql = "UPDATE employees SET first_name = ?, last_name = ?, address = ?, company_email = ?, birth_date = ?, hire_date = ?, role = ? WHERE employees_uid = ?";
		jdbcTemplate.update(sql, employee);
	}

	@Override
	public void deleteEmployeesById(String id) {
		String sql = "DELETE FROM employees WHERE employees_uid = ?";
		jdbcTemplate.update(sql, id);

	}

}