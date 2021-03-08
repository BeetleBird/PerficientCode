package com.Perficient.employee.demoapp.model;

public class Skill {
	private String skillUid;
	private String fieldUid;
	private int experience;
	
	public Skill(String skillUid, int experience) {
		this.skillUid = skillUid;
		this.fieldUid = fieldUid;
		this.experience = experience;
	}
	public Skill(String skillUid2, String fieldUid2, int experience2) {
		
	}
	public Skill() {
	
	}
	public String getSkillUid() {
		return skillUid;
	}
	public void setSkillUid(String skillUid) {
		this.skillUid = skillUid;
	}
	public String getFieldUid() {
		return fieldUid;
	}
	public void setFieldUid(String fieldUid) {
		this.fieldUid = fieldUid;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}

	
	
	
}
