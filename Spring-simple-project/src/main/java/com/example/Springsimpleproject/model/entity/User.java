package com.example.Springsimpleproject.model.entity;

import com.google.gson.Gson;
import lombok.*;

import javax.persistence.*;

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

    private String email;
    private String password;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
