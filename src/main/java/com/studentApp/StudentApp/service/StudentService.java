package com.studentApp.StudentApp.service;

import com.google.gson.Gson;
import com.studentApp.StudentApp.Repository.StudentRepository;
import com.studentApp.StudentApp.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private Gson gson=new Gson();

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(String details) {
        Student stud=gson.fromJson(details,Student.class);
        Student stud1 =new Student();

        System.out.println(stud);
        stud1.setAge(stud.getAge());
        stud1.setName(stud.getName());
        stud1.setStandard(stud.getStandard());

        stud1.setName(stud.getName());
        stud1.setAge(stud.getAge());
        stud1.setStandard(stud.getStandard());
        studentRepository.save(stud1);
   }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
         return studentRepository.findById(id).get();
    }

    public void putStudentDetails(Long id, String details) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

           Student stud=gson.fromJson(details,Student.class);
           existingStudent.setName(stud.getName());
           existingStudent.setAge(stud.getAge());
           existingStudent.setStandard(stud.getStandard());

           studentRepository.save(stud);
    }

    public void deleteStudentById(Long id) {

          studentRepository.deleteById(id);
    }
}
