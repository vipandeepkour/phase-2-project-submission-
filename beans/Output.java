package com.simplilearn.ph2.beans;

public class Output {
	private String studentName;
	private String className;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Output [studentName=" + studentName + ", className=" + className + "]";
	}
}
