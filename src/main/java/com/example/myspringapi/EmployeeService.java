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

    @Override
    public void updateEmployee(Long id, Employee employee) {
        Employee employeeToBeUpdated = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("Employee with id %s does not exist.", id))
        );
        employeeToBeUpdated.setFirstName(employee.getFirstName());
        employeeToBeUpdated.setLastName(employee.getLastName());
        employeeToBeUpdated.setAge(employee.getAge());
        employeeToBeUpdated.setEmail(employee.getEmail());
        employeeToBeUpdated.setRole(employee.getRole());
        employeeRepository.save(employeeToBeUpdated);
    }

    @Override
    public void deleteEmployee(Long id) {
        boolean idExists = employeeRepository.existsById(id);
        if(!idExists){
            throw new IllegalStateException(String.format("Employee with id %s does not exist.", id));
        }
        employeeRepository.deleteById(id);
    }

}
