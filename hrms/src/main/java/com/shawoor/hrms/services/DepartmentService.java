package com.shawoor.hrms.services;

import com.shawoor.hrms.model.Department;
import com.shawoor.hrms.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department postDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
