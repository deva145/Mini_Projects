package com.example.CourseRegistrationSystem.controller;

import com.example.CourseRegistrationSystem.model.CourseRegistry;
import com.example.CourseRegistrationSystem.service.CourseRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class CourseRegistryController {
    @Autowired
    CourseRegistryService courseRegistryService;

    @PostMapping("/courseRegistry")
    public String enrolled(@RequestParam("name") String name,@RequestParam("emailId") String email,@RequestParam("courseName")String courseName ){
        courseRegistryService.enrolled(name,email,courseName);
            return "Congratulation! "+name+" Enrollment Successful for "+courseName+".";
    }

    @GetMapping("/getCourseRegistry")
    public List<CourseRegistry> getCourseRegistry(){
        return courseRegistryService.getCourseRegistry();
    }
}
