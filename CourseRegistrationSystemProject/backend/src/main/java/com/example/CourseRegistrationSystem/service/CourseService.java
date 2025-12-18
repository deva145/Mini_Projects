package com.example.CourseRegistrationSystem.service;

import com.example.CourseRegistrationSystem.model.Course;
import com.example.CourseRegistrationSystem.model.CourseRegistry;
import com.example.CourseRegistrationSystem.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;

    CourseRegistry courseRegistry = new CourseRegistry();

    public List<Course> availCourses() {
        return courseRepo.findAll();
    }


    public Course addCourseDetails(Course course){
        return courseRepo.save(course);

    }


}
