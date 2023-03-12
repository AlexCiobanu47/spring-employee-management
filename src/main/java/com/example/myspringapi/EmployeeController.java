package com.example.myspringapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeeController {
    @GetMapping
    public List<Employee> getEmployees(){
        return List.of(
                new Employee("John", "Doe", 22, "john@yahoo.com", "Intern"),
                new Employee("James", "Michaels", 40, "james@gmail.com", "Senior")
                );
    }
}
