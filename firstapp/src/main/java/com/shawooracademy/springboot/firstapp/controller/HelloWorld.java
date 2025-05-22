package com.shawooracademy.springboot.firstapp.controller;

import com.shawooracademy.springboot.firstapp.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class HelloWorld {
@GetMapping("/greet")
    public String greet(){
    return "Hello World to Shawoor";
}

@GetMapping("/courses")
    public List<Course> getCourses() {
    Course course1 = new Course("Java", "1", "IT", 60);
    Course course2 = new Course("Python", "2", "IT", 40);
    Course course3 = new Course("C", "3", "IT", 20);

    ArrayList<Course> courses = new ArrayList<>();
    courses.add(course1);
    courses.add(course2);
    courses.add(course3);
    return courses;
}
}
