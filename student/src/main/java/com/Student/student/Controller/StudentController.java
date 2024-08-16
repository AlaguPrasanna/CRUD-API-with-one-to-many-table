package com.Student.student.Controller;

import com.Student.student.Model.Address;
import com.Student.student.Model.Student;
import com.Student.student.Service.StudentService;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.Student.student.Repository.StudentRepository;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/student")
    public Student  createStudentWithAddresses(@RequestBody Student student) {
       return studentService.saveStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents(); // call service class to get all students
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long id)
    {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable("id") Long id)
    {
        studentService.deleteStudentById(id);
    }

    @PutMapping("/student/put/{id}")
    public Student update(@RequestBody Student student,@PathVariable("id") Long id)
    {

        return studentService.updateStudent(student,id);
    }


}
