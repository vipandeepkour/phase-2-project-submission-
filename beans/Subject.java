package com.simplilearn.ph2.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_SUBJECT")
public class Subject {
	@Id
	@Column(name = "SubjectId")
	private int subjectId; // this will play a role of primary key, generated by hibernate

	@Column(name = "SubjectName")
	private String subjectName;

	public Subject() {
	}

	public Subject(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
}
