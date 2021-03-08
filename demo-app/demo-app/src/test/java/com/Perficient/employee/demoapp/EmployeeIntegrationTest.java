package com.Perficient.employee.demoapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.Perficient.employee.demoapp.model.Address;
import com.Perficient.employee.demoapp.model.Employee;
import com.Perficient.employee.demoapp.model.EmployeeDAO;
import com.Perficient.employee.demoapp.model.Field;
import com.Perficient.employee.demoapp.model.Skill;
import com.Perficient.employee.demoapp.model.jdbc.JDBCEmployeeDAO;

public class EmployeeIntegrationTest {
	private static SingleConnectionDataSource dataSource;
	private EmployeeDAO dao;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/department");
		dataSource.setUsername("postgres");
		dataSource.setPassword("Thvthv1!");
		dataSource.setAutoCommit(false);

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dataSource.destroy();
	}
	
	@BeforeEach
	void setUp() throws Exception {
	
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	 	String sql = "INSERT INTO employees(first_name, last_name, address_uid, company_email, birth_date, hire_date, role) "
				+ "VALUES ('Bob', 'Bo', '935c5f31-2b8f-4f68-adf6-9c57b38d69b2', 'sgjasd@gmail.com', '1965-06-20', '1999-01-31', 'Chief')";
		jdbcTemplate.update(sql);
		
		dao = new JDBCEmployeeDAO(dataSource);

		
	}

	@AfterEach
	void tearDown() throws Exception {
		dataSource.getConnection().rollback();
		dao = new JDBCEmployeeDAO(dataSource);
	}	
	
	@Test
	void getAllEmployees() {
		List<String> expected = new ArrayList<>(); 
		Employee employee = new Employee();
	
		expected.add("Bob");
		expected.add("Bo");
		expected.add("935c5f31-2b8f-4f68-adf6-9c57b38d69b2");
		expected.add("sgjasd@gmail.com");
		expected.add("1965-06-20");
		expected.add("1999-01-31");
		expected.add("Chief");
		
//		Address address = new Address();
//		Skill skill = new Skill();
//		Field field = new Field();
		
//		SqlRowSet expectedSql = setUp();
		
		
			String firstName = employee.getFirstName();
			String lastName = employee.getLastName();
			String id = employee.getId();
			String email = employee.getCompanyEmail();
			String birthDay = employee.getBirthDay();
			String hireDate = employee.getHiredDate();
			String role = employee.getRole();
			
		String actual = dao.getAllEmployees().toString();
		
		assertEquals(expected, actual.toString());
		
	}

}

