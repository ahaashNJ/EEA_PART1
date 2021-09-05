package com.example.eea_part1.DTO;

import java.util.List;

public class MobileModuleDTO {

    private int moduleId;
    private String moduleName;
    private String lecturer;
    private List<BatchDTO> batchList;

    public MobileModuleDTO(int moduleId, String moduleName, String lecturer, List<BatchDTO> batchList) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.lecturer = lecturer;
        this.batchList = batchList;
    }

    public MobileModuleDTO() {
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

    public List<BatchDTO> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<BatchDTO> batchList) {
        this.batchList = batchList;
    }
}
