package com.simplilearn.ph2.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.transform.Transformers;

import com.simplilearn.ph2.beans.Output;
import com.simplilearn.ph2.beans.Result;
import com.simplilearn.ph2.beans.Student;
import com.simplilearn.ph2.beans.Subject;
import com.simplilearn.ph2.beans.Teacher;

public class ClassDao {
	public Result getClassDetails() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		// create an object of Session to add the object in database table
		Session session = factory.openSession();

		Query studentsQuery = session.createQuery(
				"select vstudent.studentName as studentName, vclass.className as className FROM V_Class as vclass INNER JOIN Student as vstudent ON vclass.classId = vstudent.classId AND vclass.classId='1000'");

		Query teachersQuery = session.createQuery(
				"select vteacher.teacherName as teacherName FROM Teacher as vteacher INNER JOIN TeacherClass as vteacherclass ON vteacher.teacherId = vteacherclass.teacherId AND vteacherclass.classId='1000'");

		Query subjectsQuery = session.createQuery(
				"select vsubject.subjectName as subjectName FROM Subject as vsubject INNER JOIN SubjectClass as vsubjectclass ON vsubject.subjectId = vsubjectclass.subjectId AND vsubjectclass.classId='1000'");

		List<Teacher> teachers = teachersQuery.list();
		List<Subject> subjects = subjectsQuery.list();
		System.out.println(subjects);
		List<Output> list = studentsQuery.setResultTransformer(Transformers.aliasToBean(Output.class)).list();

		List<Student> students = new ArrayList<Student>();
		String className = list.get(0).getClassName();
		list.forEach(output -> {
			students.add(new Student(output.getStudentName()));
		});

		session.close();

		Result result = new Result();
		result.setClassName(className);
		result.setStudents(students);
		result.setSubjects(subjects);
		result.setTeachers(teachers);

		return result;
	}
}
