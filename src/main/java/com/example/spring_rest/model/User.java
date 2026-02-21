package com.example.spring_rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity                     // Marks this class as a Hibernate entity
@Table(name = "users")
@Cacheable()

public class User {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id                     // Primary key column
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID (optional)
    private Integer id;

    private String userName;
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private String password;
    public  User() {}
    public User(int id, String userName, String email, String password){
     this.id = id;
     this.userName = userName;
     this.email = email;
     this.password = password;
    }

}
