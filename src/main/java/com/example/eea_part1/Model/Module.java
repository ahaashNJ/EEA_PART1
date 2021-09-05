package com.example.eea_part1.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moduleid")
    private Integer moduleID;
    @Column(name = "module_name")
    private String moduleName;


    @ManyToOne
    @JoinColumn(name = "email")
    private User lecturerEmail;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "batch_module",
            joinColumns = @JoinColumn(name = "moduleid"),
            inverseJoinColumns = @JoinColumn(name = "batch_id")
    )
    private List<Batch> batchList;

    public Module() {
    }

    public Integer getModuleID() {
        return moduleID;
    }

    public void setModuleID(Integer moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public User getLecturerEmail() {
        return lecturerEmail;
    }

    public void setLecturerEmail(User lecturerEmail) {
        this.lecturerEmail = lecturerEmail;
    }

    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
    }
}
