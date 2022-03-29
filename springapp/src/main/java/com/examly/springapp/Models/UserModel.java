package com.examly.springapp.Models;
import javax.persistence.*;
@Entity
@Table(name="employees")
public class UserModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private String mobileNumber;
    private String role="employee";
    private Boolean active=true;

    
    public UserModel() {
    }

    public UserModel(int id, String username, String password, String email, String mobileNumber, String role,
        Boolean active) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.mobileNumber = mobileNumber;
    this.role = role;
    this.active = active;
}
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    
}
