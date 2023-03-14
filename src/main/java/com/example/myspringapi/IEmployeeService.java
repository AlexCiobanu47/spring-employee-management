package com.example.myspringapi;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getEmployees();
    void createEmployee(Employee employee);
}



