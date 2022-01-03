package com.example.Employees.registration;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;


    public RegistrationRequest(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
}
