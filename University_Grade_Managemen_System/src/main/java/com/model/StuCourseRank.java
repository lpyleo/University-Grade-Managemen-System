package com.model;

import java.io.Serializable;

public class StuCourseRank implements Serializable {
    private String lpy_Sno15;
    private String lpy_Sname15;
    private String lpy_Courseno15;
    private String lpy_Coursename15;
    private Double lpy_Grade15;
    private int lpy_Rank15;

    public StuCourseRank() {
    }

    public StuCourseRank(String lpy_Sno15, String lpy_Sname15, String lpy_Courseno15, String lpy_Coursename15, Double lpy_Grade15, int lpy_Rank15) {
        this.lpy_Sno15 = lpy_Sno15;
        this.lpy_Sname15 = lpy_Sname15;
        this.lpy_Courseno15 = lpy_Courseno15;
        this.lpy_Coursename15 = lpy_Coursename15;
        this.lpy_Grade15 = lpy_Grade15;
        this.lpy_Rank15 = lpy_Rank15;
    }

    public String getLpy_Sno15() {
        return lpy_Sno15;
    }

    public void setLpy_Sno15(String lpy_Sno15) {
        this.lpy_Sno15 = lpy_Sno15;
    }

    public String getLpy_Sname15() {
        return lpy_Sname15;
    }

    public void setLpy_Sname15(String lpy_Sname15) {
        this.lpy_Sname15 = lpy_Sname15;
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

    public Double getLpy_Grade15() {
        return lpy_Grade15;
    }

    public void setLpy_Grade15(Double lpy_Grade15) {
        this.lpy_Grade15 = lpy_Grade15;
    }

    public int getLpy_Rank15() {
        return lpy_Rank15;
    }

    public void setLpy_Rank15(int lpy_Rank15) {
        this.lpy_Rank15 = lpy_Rank15;
    }
}
