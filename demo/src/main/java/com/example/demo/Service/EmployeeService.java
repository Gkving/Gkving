package com.example.demo.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Repo.EmployeeRepo;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeRepo getEmployeeRepo() {
        return employeeRepo;
    }

    public void setEmployeeRepo(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public ResponseEntity updateEmployee(Employee employee, Long id) {

        Optional<Employee> optionalEmployee = employeeRepo.findById(id);

        System.out.println("Id: " + id);
        System.out.println("ID from Optional: " + optionalEmployee.get().getId());
        if (optionalEmployee.isPresent()) {
            optionalEmployee.get().setEmployeeCode(employee.getEmployeeCode());
            optionalEmployee.get().setName(employee.getName());
            optionalEmployee.get().setEmail(employee.getEmail());
            optionalEmployee.get().setImageUrl(employee.getImageUrl());
            optionalEmployee.get().setId(employee.getId());
            optionalEmployee.get().setJobTitle(employee.getJobTitle());
            optionalEmployee.get().setPhone(employee.getPhone());

            employeeRepo.save(optionalEmployee.get());
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);

    }

    public ResponseEntity deleteEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepo.deleteById(id);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }
}
