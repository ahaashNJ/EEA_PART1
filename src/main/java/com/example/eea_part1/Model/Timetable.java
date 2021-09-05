package com.example.eea_part1.Model;

import com.example.eea_part1.DTO.BatchDTO;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.text.AttributedString;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "timetable_id")
    private Integer timetableId;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime EndTime;

    @Column(name = "timetable_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "batch_timetable",
            joinColumns = @JoinColumn(name = "timetable_id"),
            inverseJoinColumns = @JoinColumn(name = "batch_id")
    )
    private List<Batch> batchList;

    public Timetable() {
    }

    public Timetable(Integer timetableId, LocalTime startTime, LocalTime endTime, Date date, Classroom classroom, Module module, List<Batch> batchList) {
        this.timetableId = timetableId;
        this.startTime = startTime;
        EndTime = endTime;
        this.date = date;
        this.classroom = classroom;
        this.module = module;
        this.batchList = batchList;
    }

    public Integer getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(Integer timetableId) {
        this.timetableId = timetableId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return EndTime;
    }

    public void setEndTime(LocalTime endTime) {
        EndTime = endTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
    }


}
