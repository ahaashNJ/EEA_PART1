package com.example.eea_part1.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Classroom {

    @Id
    private String classroomID;
    private String floorNum;
    private String numOfSeats;

    public Classroom() {
    }

    public Classroom(String classroomID, String floorNum, String numOfSeats) {
        this.classroomID = classroomID;
        this.floorNum = floorNum;
        this.numOfSeats = numOfSeats;
    }

    public String getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(String classroomID) {
        this.classroomID = classroomID;
    }

    public String getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum;
    }

    public String getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(String numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

}
