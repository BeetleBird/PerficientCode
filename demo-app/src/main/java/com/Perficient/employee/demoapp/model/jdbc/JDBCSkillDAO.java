package com.Perficient.employee.demoapp.model.jdbc;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.Perficient.employee.demoapp.model.Address;
import com.Perficient.employee.demoapp.model.Skill;
import com.Perficient.employee.demoapp.model.SkillDAO;


@Component
public class JDBCSkillDAO implements SkillDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCSkillDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Skill> getAllSkills() {

		List<Skill> allSkills = new ArrayList<>();

		String sql = "SELECT * FROM skill";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while (results.next()) {

			String fieldUid = results.getString("field_uid");
			String skillUid = results.getString("skill_uid");
			int experience = results.getInt("experience");
			Skill skill = new Skill(skillUid, fieldUid, experience);
//			skill.getExperience();
//			skill.getFieldUid();
//			skill.getSkillUid();

			allSkills.add(skill);
		}

		return allSkills;
	}

	@Override
	public Skill getTechnicalSkillByEmployeeId(String id) {
		Skill department2 = null;
		String sqlReturnDepartmentSearch = "SELECT department_id, name FROM department WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlReturnDepartmentSearch, id);
		if (results.next()) {
//			department2 = new Address();
			String id2 = results.getString("department_id");
//			String department = results.getString("name");
//			department2.setId(id2);
//			department2.setName(department);

		}
		return department2;
	

	}
	
	@Override
	public void addSkill(Skill skill) {
		String sql = "INSERT INTO skill(experience) VALUES(?)";
		String id = skill.getFieldUid();
		jdbcTemplate.update(sql, id);
	}


	@Override
	public void updateSkill(String employeeId) {

		String sql = "UPDATE skill SET experience = ? WHERE employees_uid = ?";
		jdbcTemplate.update(sql);

	}

	@Override
	public void deleteSkillById(String id) {
		String sql = "DELETE FROM skill WHERE employees_uid = ?";
		jdbcTemplate.update(sql, id);

	}


}