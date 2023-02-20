package com.example.Springsimpleproject.model.entity;

import com.google.gson.Gson;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "userEntity")
@Table(name = "userTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Email should be valid")
    @Size(min = 6, max = 30, message = "email should be between 6 and 30 characters")
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min = 8, max = 20, message = "Password should be between 8 and 20 characters")
    private String password;


    // One-to-many relationship with Order entity
    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new HashSet<>();

    // One-to-many relationship with Payment entity
    @OneToMany(mappedBy = "user")
    private Set<Payment> payments = new HashSet<>();

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
