package com.example.sanzar.controller;

import com.example.sanzar.entity.Department;
import com.example.sanzar.error.DepartmentNotFound;
import com.example.sanzar.service.DepartmentService;
import com.example.sanzar.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private  DepartmentService departmentService;
    @PostMapping("/departments")
public Department saveDepartment(@Valid @RequestBody Department department)
{
    return departmentService.saveDepartment(department);

}

@GetMapping("/departments")
    public List<Department> fetchDepartmentlist()
{
    return departmentService.fetchdepartmentlist();
}

@GetMapping("/departments/{id}")
public Department fetchdeptbyid(@PathVariable("id") Long departmentId) throws DepartmentNotFound {

return departmentService.fetchdeptbyid(departmentId);

}
    @DeleteMapping("/departments/{id}")
    public String deletedept(@PathVariable("id")Long departmentID)
    {
        departmentService.deletedpet(departmentID);
        return "deleted";
    }
    @PutMapping("/departments/{id}")
    public Department updatedept(@PathVariable("id")Long departmentID, @RequestBody Department department)
    {

    return departmentService.updatedpt(departmentID,department);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
