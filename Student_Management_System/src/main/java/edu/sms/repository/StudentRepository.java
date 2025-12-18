package edu.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{


}
