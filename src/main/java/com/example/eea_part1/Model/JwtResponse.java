package com.example.eea_part1.Model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final String userType;
    private final String email;

    public JwtResponse(String jwttoken, String userType, String email) {
        this.jwttoken = jwttoken;
        this.userType = userType;
        this.email = email;
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public String getUserType() {
        return userType;
    }

    public String getEmail() {
        return email;
    }
}
