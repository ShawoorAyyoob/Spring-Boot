package com.shawoor.hrms.services;

import com.shawoor.hrms.model.Employee;
import com.shawoor.hrms.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee postEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
