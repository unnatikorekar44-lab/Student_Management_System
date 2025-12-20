package edu.sms.service;

import java.util.List;

import edu.sms.model.Student;

public interface StudentService {

	 public List<Student> getAllStudents();

	 public void saveStudentDetail(Student student);

	 public void deleteStudent(int studentId);

	 public List<Student> searchStudentByBatch(String batchNumber);


}