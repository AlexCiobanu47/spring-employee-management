package com.example.myspringapi;

import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EmployeeService implements IEmployeeService{
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List <Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
