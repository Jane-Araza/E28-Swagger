package com.example.E28.Service;

import com.example.E28.Entity.CourseEntity;
import com.example.E28.Entity.StudentEntity;
import com.example.E28.Repository.CourseRepository;
import com.example.E28.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public StudentEntity addStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<StudentEntity> findById(Long id){
        return studentRepository.findById(id);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public StudentEntity update(long id, StudentEntity studentEntity) {
        studentEntity.setStudentId(id);
        return studentRepository.save(studentEntity);
    }

    public StudentEntity enrolStudent(Long id, Long course_id) {
        StudentEntity student=studentRepository.findById(id).get();
        student.getCourses().add(courseRepository.findById(course_id).get());
        studentRepository.save(student);
        return student;
    }
    public StudentEntity dropStudent(Long id, Long course_id) {
        StudentEntity student=studentRepository.findById(id).get();
        student.getCourses().remove(courseRepository.findById(course_id).get());
        studentRepository.save(student);
        return student;
    }
}


