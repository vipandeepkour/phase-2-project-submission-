package com.simplilearn.ph2.beans;

import java.util.List;

public class Result {
	private List<Student> students;
	private List<Teacher> teachers;
	private List<Subject> subjects;
	private String className;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Result [students=" + students + ", teachers=" + teachers + ", subjects=" + subjects + ", className="
				+ className + "]";
	}

}
