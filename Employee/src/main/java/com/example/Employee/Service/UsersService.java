package com.example.Employee.Service;

import com.example.Employee.Model.Users;
import com.example.Employee.Repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;

    public UsersRepo getUsersRepo() {
        return usersRepo;
    }

    public void setUsersRepo(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public ResponseEntity updateUsers (Users users, Long id){

        Optional<Users> optionalUsers = usersRepo.findById(id);

        System.out.println("Id: " + id);
        System.out.println("ID from Optional: " + optionalUsers.get().getId());
        if (optionalUsers.isPresent()){

            optionalUsers.get().setId(users.getId());
            optionalUsers.get().setName(users.getName());
            optionalUsers.get().setLastname(users.getLastname());
            optionalUsers.get().setEmail(users.getEmail());
            optionalUsers.get().setDob(users.getDob());
            optionalUsers.get().setPhone(users.getPhone());
            optionalUsers.get().setUsersCode(users.getUsersCode());


            usersRepo.save(optionalUsers.get());
            return ResponseEntity.ok(HttpStatus.OK);

        }

            return ResponseEntity.ok(HttpStatus.NOT_FOUND);

    }

        public ResponseEntity deleteUsers(Long id){

            Optional<Users> optionalUsers = usersRepo.findById(id);
            if (optionalUsers.isPresent()){
                usersRepo.deleteById(id);
                return ResponseEntity.ok(HttpStatus.OK);

            }
                return ResponseEntity.ok(HttpStatus.NOT_FOUND);

        }





}
