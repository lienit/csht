package com.java.csht.model;

public class AskBuy {
    private Integer aid;

    private String aname;

    private String amobile;

    private Integer sortid;

    private Integer userid;

    private String sortname;

    private String username;

    private User user;

    private Sort sort;

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

    public String getAmobile() {
        return amobile;
    }

    public void setAmobile(String amobile) {
        this.amobile = amobile == null ? null : amobile.trim();
    }

    public Integer getSortid() {
        return sortid;
    }

    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname == null ? null : sortname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "AskBuy{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", amobile='" + amobile + '\'' +
                ", sortid=" + sortid +
                ", userid=" + userid +
                ", sortname='" + sortname + '\'' +
                ", username='" + username + '\'' +
                ", user=" + user +
                ", sort=" + sort +
                '}';
    }
}