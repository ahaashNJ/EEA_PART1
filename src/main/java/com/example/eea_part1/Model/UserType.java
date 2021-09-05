package com.example.eea_part1.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserType {

    @Id
    private String userTypeID;
    private String userType;

    public UserType() {
    }

    public String getUserTypeID() {
        return userTypeID;
    }

    public void setUserTypeID(String userTypeID) {
        this.userTypeID = userTypeID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
