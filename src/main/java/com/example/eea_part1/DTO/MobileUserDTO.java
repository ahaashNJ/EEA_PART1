package com.example.eea_part1.DTO;

import com.example.eea_part1.Model.Batch;

public class MobileUserDTO {

    private String email;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String password;
    private String userType;
    private Batch batchId;

    public MobileUserDTO(String email, String firstName, String lastName, String contactNumber, String password, String userType, Batch batchId) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.password = password;
        this.userType = userType;
        this.batchId = batchId;
    }

    public MobileUserDTO() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Batch getBatchId() {
        return batchId;
    }

    public void setBatchId(Batch batchId) {
        this.batchId = batchId;
    }
}
