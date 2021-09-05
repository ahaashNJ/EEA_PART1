package com.example.eea_part1.DTO;

import com.example.eea_part1.Model.Batch;

import java.util.List;

public class TimetableDTOMobile {

    private int timetableId;
    private String startTime;
    private String endTime;
    private String timetableDate;
    private String classroom;
    private String module;
    List<Batch> batchList;

    public TimetableDTOMobile() {
    }

    public int getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(int timetableId) {
        this.timetableId = timetableId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTimetableDate() {
        return timetableDate;
    }

    public void setTimetableDate(String timetableDate) {
        this.timetableDate = timetableDate;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
    }
}
