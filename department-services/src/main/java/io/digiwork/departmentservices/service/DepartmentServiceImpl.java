package io.digiwork.departmentservices.service;

import io.digiwork.departmentservices.model.Department;
import io.digiwork.departmentservices.repository.DepartmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public Department createDepartment(Department department) {
        log.info("Create department service");
        return departmentRepo.save(department);
    }

    @Override
    public Department findDepartmentById(Long id) {
        log.info("Find department by id service");
        return departmentRepo.findById(id).orElseThrow();
    }
}
