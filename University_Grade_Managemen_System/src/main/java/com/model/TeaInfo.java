package com.model;

import java.io.Serializable;

public class TeaInfo implements Serializable {
    private String lpy_Tno15;
    private String lpy_Tname15;
    private String lpy_Tcollege15;
    private String lpy_Tsex15;
    private int lpy_Tage15;
    private String lpy_Tprofess15;
    private String lpy_Tphone15;

    public TeaInfo() {
    }

    public TeaInfo(String lpy_Tno15, String lpy_Tname15, String lpy_Tcollege15, String lpy_Tsex15, int lpy_Tage15, String lpy_Tprofess15, String lpy_Tphone15) {
        this.lpy_Tno15 = lpy_Tno15;
        this.lpy_Tname15 = lpy_Tname15;
        this.lpy_Tcollege15 = lpy_Tcollege15;
        this.lpy_Tsex15 = lpy_Tsex15;
        this.lpy_Tage15 = lpy_Tage15;
        this.lpy_Tprofess15 = lpy_Tprofess15;
        this.lpy_Tphone15 = lpy_Tphone15;
    }

    public String getLpy_Tno15() {
        return lpy_Tno15;
    }

    public void setLpy_Tno15(String lpy_Tno15) {
        this.lpy_Tno15 = lpy_Tno15;
    }

    public String getLpy_Tname15() {
        return lpy_Tname15;
    }

    public void setLpy_Tname15(String lpy_Tname15) {
        this.lpy_Tname15 = lpy_Tname15;
    }

    public String getLpy_Tcollege15() {
        return lpy_Tcollege15;
    }

    public void setLpy_Tcollege15(String lpy_Tcollege15) {
        this.lpy_Tcollege15 = lpy_Tcollege15;
    }

    public String getLpy_Tsex15() {
        return lpy_Tsex15;
    }

    public void setLpy_Tsex15(String lpy_Tsex15) {
        this.lpy_Tsex15 = lpy_Tsex15;
    }

    public int getLpy_Tage15() {
        return lpy_Tage15;
    }

    public void setLpy_Tage15(int lpy_Tage15) {
        this.lpy_Tage15 = lpy_Tage15;
    }

    public String getLpy_Tprofess15() {
        return lpy_Tprofess15;
    }

    public void setLpy_Tprofess15(String lpy_Tprofess15) {
        this.lpy_Tprofess15 = lpy_Tprofess15;
    }

    public String getLpy_Tphone15() {
        return lpy_Tphone15;
    }

    public void setLpy_Tphone15(String lpy_Tphone15) {
        this.lpy_Tphone15 = lpy_Tphone15;
    }
}
