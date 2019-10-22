package com.java.csht.model;

public class AdminUser {
    private Integer id;

    private String aname;

    private String apsw;

    private String amobile;

    private String amailbox;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getApsw() {
        return apsw;
    }

    public void setApsw(String apsw) {
        this.apsw = apsw == null ? null : apsw.trim();
    }

    public String getAmobile() {
        return amobile;
    }

    public void setAmobile(String amobile) {
        this.amobile = amobile == null ? null : amobile.trim();
    }

    public String getAmailbox() {
        return amailbox;
    }

    public void setAmailbox(String amailbox) {
        this.amailbox = amailbox == null ? null : amailbox.trim();
    }
}