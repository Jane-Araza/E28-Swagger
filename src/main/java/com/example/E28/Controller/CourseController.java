package com.example.E28.Controller;


import com.example.E28.Entity.CourseEntity;
import com.example.E28.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseService courseService;


    //add course two parameters are needed the name and description will save course.
    @PostMapping(path = "/course")
    public @ResponseBody String addCourse(@RequestParam String name,
                                          @RequestParam String description) {
        return courseService.addCourse(name, description);
    }

    //Retrieve all course from the database
    @GetMapping(path = "/courses")
    public List<CourseEntity> getAllCourses() {
        return courseService.getAllCourses();
    }

    //Get Specific course by Id
    @GetMapping(path = "/courses/{id}")
    public Optional<CourseEntity> getCourseById(@PathVariable Long id) {
        return courseService.findCourseById(id);
    }

    //Delete a specific course with specified id
    @DeleteMapping(path = "/delete_course/{id}")
    public void deleteCourseById(@PathVariable Long id) {
        courseService.deleteCourseById(id);
    }

    //Update the Specific Course using id as path variable
    @PutMapping(path = "update_course/{id}")
    public CourseEntity updateCourse(@PathVariable Long id, @RequestBody CourseEntity courseEntity) {
        courseEntity.setCourseId(id);
        return courseService.updateCourse(id, courseEntity);
    }
}
