package com.Perficient.employee.demoapp.model;

import java.util.List;

import javax.validation.Valid;

public interface SkillDAO {

	public List<Skill> getAllSkills();

	public Skill getTechnicalSkillByEmployeeId(String employeeId);

	public void addSkill(Skill skill);

	public void updateSkill(@Valid String employeeId);

	public void deleteSkillById(String id);
}