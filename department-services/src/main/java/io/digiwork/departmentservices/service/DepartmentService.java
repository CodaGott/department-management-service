package io.digiwork.departmentservices.service;

import io.digiwork.departmentservices.model.Department;


public interface DepartmentService {


    Department createDepartment(Department department);

    Department findDepartmentById(Long id);
}
