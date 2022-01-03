package com.example.Employee.Controller;

import com.example.Employee.Model.Users;
import com.example.Employee.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
//import java.util.Optional;
//import java.util.Random;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping ("/users")
public class UsersResource {

    @Autowired
    private UsersService usersService;


    @GetMapping ("/all")
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> users = usersService.getUsersRepo().findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Users> getUsersById (@PathVariable ("id") Long id){
        Optional<Users> users = usersService.getUsersRepo().findById(id);
        return new ResponseEntity(users, HttpStatus.OK);
    }


    @PostMapping ("/add")
    public ResponseEntity<Users> addUsers (@RequestBody Users users){
        Random rand = new Random();
        String code = String.format("%06d", rand.nextInt(10000));
        users.setUsersCode(code);
        Users newUsers = usersService.getUsersRepo().save(users);
        return new ResponseEntity<>(newUsers, HttpStatus.CREATED);

    }

    @PostMapping ("/update/{id}")
    public ResponseEntity updateUsers (@RequestBody Users users, @PathVariable ("id") Long id){
        return usersService.updateUsers (users, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") Long id) {
        return usersService.deleteUsers(id);

    }

}
