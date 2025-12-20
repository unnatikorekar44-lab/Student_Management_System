package edu.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sms.model.Student;
import edu.sms.repository.StudentRepository;

@Service
public class StudentServiceimpl implements StudentService {

	@Autowired
	StudentRepository sr;
	
	@Override
	public List<Student> getAllStudents() {
		
		return sr.findAll();
	}

	public void saveStudentDetail(Student student) {
		
		sr.save(student);
	}

	@Override
	public void deleteStudent(int studentId) {
		sr.deleteById(studentId);
		
	}

	@Override
	public List<Student> searchStudentByBatch(String batchNumber) {
		
		List<Student> batchStudents =sr.findByBatchNumber(batchNumber);
		return batchStudents;
	}


	
}
