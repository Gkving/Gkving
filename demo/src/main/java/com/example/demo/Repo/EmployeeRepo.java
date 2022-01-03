package com.example.demo.Repo;

import com.example.demo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Optional<Employee> findById(Long id);

    void deleteById(Long id);

}
