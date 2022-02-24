package io.digiwork.departmentservices.controller;

import io.digiwork.departmentservices.model.Department;
import io.digiwork.departmentservices.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public Department createDepartment(@RequestBody Department department){
        log.info("Create department controller");
        return departmentService.createDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable Long id){
        log.info("Find department by id controller");
        return departmentService.findDepartmentById(id);
    }
}
