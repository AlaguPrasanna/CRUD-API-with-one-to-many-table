package com.Student.student.Service;


import com.Student.student.Model.Student;

import java.util.List;

public interface StudentServiceInterface {


    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(Long id);
    public void deleteStudentById(Long id);
    public Student updateStudent(Student student, Long id);
}
