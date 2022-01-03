package com.example.Employee.Model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (nullable = false, updatable = false)
    private Long Id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String dob;
    @Column (nullable = false, updatable = false)
    private String usersCode;

    public Users(){

    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getUsersCode() {
        return usersCode;
    }

    public void setUsersCode(String usersCode) {
        this.usersCode = usersCode;
    }




}
