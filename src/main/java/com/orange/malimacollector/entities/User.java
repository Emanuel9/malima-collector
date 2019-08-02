package com.orange.malimacollector.entities;

import com.orange.malimacollector.model.Roles;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Roles role = Roles.ROLE_USER;

    public User() { }

    public User(User user) {
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

    public User(String password, String email, Roles role) {
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
