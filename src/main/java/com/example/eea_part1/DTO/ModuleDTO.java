package com.example.eea_part1.DTO;

import com.example.eea_part1.Model.Batch;
import com.example.eea_part1.Model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class ModuleDTO {

    private int moduleId;
    private String moduleName;
    private String lecturer;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String[]  batchList;

    public ModuleDTO(int moduleId, String moduleName, String lecturer, String[] batchList) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.lecturer = lecturer;
        this.batchList = batchList;
    }

    public ModuleDTO() {
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String[] getBatchList() {
        return batchList;
    }

    public void setBatchList(String[] batchList) {
        this.batchList = batchList;
    }

}
