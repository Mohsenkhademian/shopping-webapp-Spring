package com.example.Springsimpleproject.model.entity;

import com.google.gson.Gson;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "userEntity")
@Table(name = "userTable")
public class User implements UserDetails {
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

    private String username;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return username ;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public enum Role {
        ROLE_USER, ROLE_ADMIN, ROLE_EMPLOYEE, ROLE_COMPANY
    }
}
