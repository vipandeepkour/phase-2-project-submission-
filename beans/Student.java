package com.simplilearn.ph2.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "V_STUDENT")
public class Student {
	@Id
	@Column(name = "StudentId")
	private int studentId; // this will play a role of primary key, generated by hibernate

	@Column(name = "ClassId")
	private int classId;

	@Column(name = "StudentName")
	private String studentName;

	public Student() {
	}

	public Student(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}

}
