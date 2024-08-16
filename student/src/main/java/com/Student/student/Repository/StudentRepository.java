package com.Student.student.Repository;

import com.Student.student.Model.Address;
import com.Student.student.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
