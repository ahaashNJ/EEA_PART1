package com.example.eea_part1.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "batch_id")
    private Integer batchId;
    @Column(name = "batch_name")
    private String batchName;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
        name = "batch_module",
        joinColumns = @JoinColumn(name = "batch_id"),
        inverseJoinColumns = @JoinColumn(name = "moduleid")
        )
    private List<Module> moduleList;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "batch_timetable",
            joinColumns = @JoinColumn(name = "batch_id"),
            inverseJoinColumns = @JoinColumn(name = "timetable_id")
    )
    private List<Timetable> timetableList;



    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
