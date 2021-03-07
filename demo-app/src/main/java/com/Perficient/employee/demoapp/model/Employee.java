package com.Perficient.employee.demoapp.model;

import java.time.LocalDate;
import java.util.UUID;

public class Employee {
	
	private String id;
	private String firstName;
	private String lastName;
	private Address address;
	private String companyEmail;
	private String birthDay;
	private String hiredDate;
	private String role;
	private Skill skill;
	private Field field;
	
	
	public Employee(String id, String firstName, String lastName, Address address, String companyEmail, String birthDay,
			String hiredDate, String role, Skill skill, Field field) {
//		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.companyEmail = companyEmail;
		this.birthDay = birthDay;
		this.hiredDate = hiredDate;
		this.role = role;
		this.skill = skill;
		this.field = field;
	
	}


//	public UUID getUid() {
//		return uid;
//	}
//
//
//	public void setUid(UUID uid) {
//		this.uid = uid;
//	}


	public Field getField() {
		return field;
	}


	public void setField(Field field) {
		this.field = field;
	}


	public Employee(String employeeId, String lastName2) {
		// TODO Auto-generated constructor stub
	}


	public Employee(String employeeId) {
		// TODO Auto-generated constructor stub
	}


	public Employee(String id2, String firstName2, String lastName2, String addressActual, String companyEmail2,
			String birthDay2, String hiredDate2, String role2, String address_uid, String street, String city,
			String region, String postal, String country) {
		// TODO Auto-generated constructor stub
	}



	public Skill getSkill() {
		return skill;
	}


	public void setSkill(Skill skill) {
		this.skill = skill;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getHiredDate() {
		return hiredDate;
	}
	public void setHiredDate(String hiredDate) {
		this.hiredDate = hiredDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}