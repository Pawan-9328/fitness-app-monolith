package com.project.fitness_monolith.dto;


import com.project.fitness_monolith.Model.UserRole;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private UserRole role;


}
