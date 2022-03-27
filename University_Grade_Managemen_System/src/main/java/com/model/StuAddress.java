package com.model;

import java.io.Serializable;

public class StuAddress implements Serializable {
    private String lpy_Shometown15;
    private String lpy_Num15;

    public StuAddress() {
    }

    public StuAddress(String lpy_Shometown15, String lpy_Num15) {
        this.lpy_Shometown15 = lpy_Shometown15;
        this.lpy_Num15 = lpy_Num15;
    }

    public String getLpy_Shometown15() {
        return lpy_Shometown15;
    }

    public void setLpy_Shometown15(String lpy_Shometown15) {
        this.lpy_Shometown15 = lpy_Shometown15;
    }

    public String getLpy_Num15() {
        return lpy_Num15;
    }

    public void setLpy_Num15(String lpy_Num15) {
        this.lpy_Num15 = lpy_Num15;
    }
}
