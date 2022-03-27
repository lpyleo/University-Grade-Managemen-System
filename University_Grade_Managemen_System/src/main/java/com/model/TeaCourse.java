package com.model;

import java.io.Serializable;

public class TeaCourse implements Serializable {
    private String lpy_Tno15;
    private String lpy_Tname15;
    private String lpy_Courseno15;
    private String lpy_Coursename15;
    private String lpy_Classno15;
    private String lpy_Classname15;

    public TeaCourse() {
    }

    public TeaCourse(String lpy_Tno15, String lpy_Tname15, String lpy_Courseno15, String lpy_Coursename15, String lpy_Classno15, String lpy_Classname15) {
        this.lpy_Tno15 = lpy_Tno15;
        this.lpy_Tname15 = lpy_Tname15;
        this.lpy_Courseno15 = lpy_Courseno15;
        this.lpy_Coursename15 = lpy_Coursename15;
        this.lpy_Classno15 = lpy_Classno15;
        this.lpy_Classname15 = lpy_Classname15;
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

    public String getLpy_Classno15() { return lpy_Classno15; }

    public void setLpy_Classno15(String lpy_Classno15) { this.lpy_Classno15 = lpy_Classno15; }

    public String getLpy_Classname15() { return lpy_Classname15; }

    public void setLpy_Classname15(String lpy_Classname15) { this.lpy_Classname15 = lpy_Classname15; }
}
