package com.studentApp.StudentApp.controller;

import com.studentApp.StudentApp.model.Student;
import com.studentApp.StudentApp.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public String createStudent(@RequestBody String details){
        System.out.println("Students details"+details);
        studentService.createStudent(details);

        return "student created";
    }
    @GetMapping
    public String getStudents(){
        List<Student> studs=studentService.getAllStudent();
        System.out.println("list details"+studs);
        return studs.toString();


    }
    @GetMapping("/{id}")
    public String getStudentById(@PathVariable Long id){
        Student stud=studentService.getStudentById(id);

        return stud.toString();
    }
    @PutMapping("/{id}")
    public String putStudents(@PathVariable Long id,@RequestBody String details){
        studentService.putStudentDetails(id,details);
        return "Update succesfully";
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        try {
            studentService.deleteStudentById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Student remove have id:"+id;
    }

}
