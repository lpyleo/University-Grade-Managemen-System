package com.model;

import java.io.Serializable;

public class StuRank implements Serializable {
    private String lpy_Sno15;
    private String lpy_Sname15;
    private Double lpy_AvgGpa15;
    private int lpy_Rank15;

    public StuRank() {
    }

    public StuRank(String lpy_Sno15, String lpy_Sname15, Double lpy_AvgGpa15, int lpy_Rank15) {
        this.lpy_Sno15 = lpy_Sno15;
        this.lpy_Sname15 = lpy_Sname15;
        this.lpy_AvgGpa15 = lpy_AvgGpa15;
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

    public Double getLpy_AvgGpa15() {
        return lpy_AvgGpa15;
    }

    public void setLpy_AvgGpa15(Double lpy_AvgGpa15) {
        this.lpy_AvgGpa15 = lpy_AvgGpa15;
    }

    public int getLpy_Rank15() {
        return lpy_Rank15;
    }

    public void setLpy_Rank15(int lpy_Rank15) {
        this.lpy_Rank15 = lpy_Rank15;
    }
}
