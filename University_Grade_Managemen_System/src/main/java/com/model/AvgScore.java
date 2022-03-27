package com.model;

import java.io.Serializable;

public class AvgScore implements Serializable {
    private String lpy_Courseno15;
    private String lpy_Coursename15;
    private Double lpy_Courseavgscore15;

    public AvgScore() {
    }

    public AvgScore(String lpy_Courseno15, String lpy_Coursename15, Double lpy_Courseavgscore15) {
        this.lpy_Courseno15 = lpy_Courseno15;
        this.lpy_Coursename15 = lpy_Coursename15;
        this.lpy_Courseavgscore15 = lpy_Courseavgscore15;
    }

    public String getLpy_Courseno15() {
        return lpy_Courseno15;
    }

    public void setLpy_Courseno15(String lpy_Courseno15) {
        this.lpy_Courseno15 = lpy_Courseno15;
    }

    public String getLpy_Coursename15() {
        return lpy_Coursename15;
    }

    public void setLpy_Coursename15(String lpy_Coursename15) {
        this.lpy_Coursename15 = lpy_Coursename15;
    }

    public Double getLpy_Courseavgscore15() {
        return lpy_Courseavgscore15;
    }

    public void setLpy_Courseavgscore15(Double lpy_Courseavgscore15) {
        this.lpy_Courseavgscore15 = lpy_Courseavgscore15;
    }
}
