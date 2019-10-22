package com.java.csht.model;

public class AskBuy {
    private Integer aid;

    private String aname;

    private String aprice;

    private String amobile;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getAprice() {
        return aprice;
    }

    public void setAprice(String aprice) {
        this.aprice = aprice == null ? null : aprice.trim();
    }

    public String getAmobile() {
        return amobile;
    }

    public void setAmobile(String amobile) {
        this.amobile = amobile == null ? null : amobile.trim();
    }
}