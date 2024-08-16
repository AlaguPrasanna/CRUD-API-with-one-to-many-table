package com.Student.student.Service;

import com.Student.student.Model.Address;
import com.Student.student.Model.Student;
import com.Student.student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    private StudentRepository studentRepository;

    //post method to create a student in the database
    public Student saveStudent(Student student) {
        for (Address address : student.getAddresses()) {
            address.setStudent(student); // Ensure the relationship is set
        }

        return studentRepository.save(student);

    }

    //get method to get all students in the database
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    //get method to get a particular student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    //delete method to delete a student by ID
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    //Put method to update a specific data in database
    @Override
    public Student updateStudent(Student updatedStudent, Long id) {
        Student optionalStudent = getStudentById(id);
        if (optionalStudent!=null) {
            Student student = optionalStudent;
            student.setName(updatedStudent.getName());
            student.getAddresses().clear();
            student.getAddresses().addAll(updatedStudent.getAddresses());
            for (Address address : student.getAddresses()) {
                address.setStudent(student);
            }
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found with  id " + id);
        }

}}
