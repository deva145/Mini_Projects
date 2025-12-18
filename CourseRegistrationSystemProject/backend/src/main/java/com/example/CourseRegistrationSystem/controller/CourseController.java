package com.example.CourseRegistrationSystem.controller;

import com.example.CourseRegistrationSystem.model.Course;
import com.example.CourseRegistrationSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/availCourses")
    public List<Course> availcourses(){
        return courseService.availCourses();
    }

    @PostMapping("/addCourseDetails")
    public Course addCourseDetails(@RequestBody Course course){
        return courseService.addCourseDetails(course);
    }
}
