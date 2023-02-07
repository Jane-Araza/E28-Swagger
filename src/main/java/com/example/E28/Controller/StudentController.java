package com.example.E28.Controller;


import com.example.E28.Entity.CourseEntity;
import com.example.E28.Entity.StudentEntity;
import com.example.E28.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(path ="/student")

    //Save the Student Details
    public StudentEntity addStudent(@RequestBody StudentEntity studentEntity){
        return studentService.addStudent(studentEntity);
    }

    //Get all the students
    @GetMapping(path = "/students")
    public @ResponseBody List<StudentEntity> getAllStudents(){
        return studentService.getAllStudents();
    }

    //Get Specific Student
    @GetMapping(path = "/students/{id}")
    public Optional<StudentEntity> getStudentById(@PathVariable Long id){

        return studentService.findById(id);
    }

    //Delete Specific Student
    @DeleteMapping(path = "/delete/{id}")
    public void deleteById(@PathVariable Long id){
        studentService.deleteById(id);
    }

    //Update the Specific Student
    @PutMapping(path = "/update/{id}")
    public StudentEntity updateStudent(@PathVariable Long id, @RequestBody StudentEntity studentEntity){
        studentEntity.setStudentId(id);
        return studentService.update(id, studentEntity);
    }
    @PutMapping("/students/{id}/enroll/{course_id}")
    public StudentEntity enrolStudent(@PathVariable("id") Long id, @PathVariable("course_id") Long course_id ) {
        return studentService.enrolStudent(id, course_id);
    }
    @DeleteMapping("/students/{id}/drop/{course_id}")
    public StudentEntity dropStudent(@PathVariable("id") Long id, @PathVariable("course_id") Long course_id ) {
        studentService.dropStudent(id, course_id);
        return studentService.dropStudent(id,course_id);
    }

}
