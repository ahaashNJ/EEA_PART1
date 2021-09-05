package com.example.eea_part1.DTO;

import java.util.Date;
import java.util.List;

public class BatchDTO {

    private Integer batchId;
    private String batchName;
    private String startDate;
    private String endDate;


    public BatchDTO() {
    }

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public BatchDTO(Integer batchId, String batchName, String startDate, String endDate) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
