package com.Perficient.employee.demoapp.model;

public class Field {
private String fieldUid;
private String name;
private String type;
public Field(String fieldUid, String name, String type) {
	super();
	this.fieldUid = fieldUid;
	this.name = name;
	this.type = type;
}
public String getFieldUid() {
	return fieldUid;
}
public void setFieldUid(String fieldUid) {
	this.fieldUid = fieldUid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
