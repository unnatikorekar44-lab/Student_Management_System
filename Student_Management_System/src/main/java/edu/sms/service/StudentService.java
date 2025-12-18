package edu.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sms.model.Student;
import edu.sms.repository.StudentRepository;

@Service
public interface StudentService {

	public static final StudentRepository repo = null;


	public default List<Student> getAllStudents() {
	return repo.findAll();
	}


	public default void saveStudent(Student student) {
	repo.save(student);
	}
}