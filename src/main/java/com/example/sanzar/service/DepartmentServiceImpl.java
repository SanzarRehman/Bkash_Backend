package com.example.sanzar.service;

import com.example.sanzar.entity.Department;
import com.example.sanzar.error.DepartmentNotFound;
import com.example.sanzar.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchdepartmentlist() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchdeptbyid(Long departmentId) throws DepartmentNotFound {
        Optional<Department> department= departmentRepository.findById(departmentId);
        if(!department.isPresent())
        {
            throw new DepartmentNotFound("Department not found");
        }
        return department.get();
    }

    @Override
    public Department deletedpet(Long departmentID) {
        departmentRepository.deleteById(departmentID);
        return null;
    }

    @Override
    public Department updatedpt(Long departmentID, Department department) {
        Department depDB=departmentRepository.findById(departmentID).get();
        if(Objects.nonNull(department.getDepartmentName()) &&
                 !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName((department.getDepartmentName()));

        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode((department.getDepartmentCode()));

        }
        if(Objects.nonNull(department.getDepartmentAddresss()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddresss())){
            depDB.setDepartmentAddresss((department.getDepartmentAddresss()));

        }
        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }





}
