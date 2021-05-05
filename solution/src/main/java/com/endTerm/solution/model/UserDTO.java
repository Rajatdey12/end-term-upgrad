package com.endTerm.solution.model;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="users")
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @NotEmpty(message = "Name is required")
    private String name;

    @Max(100)
    @NotNull
    private Integer age;

    @NotEmpty(message = "Email is required")
    @Email
    private String emailId;

    @NotEmpty(message = "Address is required")
    private String address;

    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Mobile number is invalid")
    private String phoneNumber;

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
