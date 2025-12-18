package com.example.CourseRegistrationSystem.service;

import com.example.CourseRegistrationSystem.model.CourseRegistry;
import com.example.CourseRegistrationSystem.repository.CourseRegistryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseRegistryService {
    @Autowired
    CourseRegistryRepo courseRegistryRepo;

    public List<CourseRegistry> getCourseRegistry() {
        return courseRegistryRepo.findAll();
    }

    public CourseRegistry enrolled(String name, String email, String courseName) {
        CourseRegistry courseRegistry = new CourseRegistry();
        courseRegistry.setName(name);
        courseRegistry.setEmailId(email);
        courseRegistry.setCourseName(courseName);
        return courseRegistryRepo.save(courseRegistry);
    }
}
