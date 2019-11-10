package com.java.csht.model;

import java.util.List;

public class Sort {
    private Integer id;

    private String cname;

    private Integer number;

    private List<Sell> sells;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Sell> getSells() {
        return sells;
    }

    public void setSells(List<Sell> sells) {
        this.sells = sells;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", sell=" + sells +
                '}';
    }
}