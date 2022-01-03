package com.example.Employee.Repo;

import com.example.Employee.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository <Users, Long>{
    @Override
    Optional<Users> findById(Long Id);

    @Override
    void deleteById(Long aLong);
}
