package com.java.csht.model;

public class Sell {
    private Integer sid;

    private String sname;

    private Float sprice;

    private Float ssellprice;

    private Integer sortid;

    private String sdep;

    private String smobile;

    private Integer userid;

    private String username;

    private String sortname;

    private User user;

    private  Sort sort;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public Float getSprice() {
        return sprice;
    }

    public void setSprice(Float sprice) {
        this.sprice = sprice;
    }

    public Float getSsellprice() {
        return ssellprice;
    }

    public void setSsellprice(Float ssellprice) {
        this.ssellprice = ssellprice;
    }

    public Integer getSortid() {
        return sortid;
    }

    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }

    public String getSdep() {
        return sdep;
    }

    public void setSdep(String sdep) {
        this.sdep = sdep == null ? null : sdep.trim();
    }

    public String getSmobile() {
        return smobile;
    }

    public void setSmobile(String smobile) {
        this.smobile = smobile == null ? null : smobile.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname == null ? null : sortname.trim();
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
        return "Sell{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sprice=" + sprice +
                ", ssellprice=" + ssellprice +
                ", sortid=" + sortid +
                ", sdep='" + sdep + '\'' +
                ", smobile='" + smobile + '\'' +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", sortname='" + sortname + '\'' +
                ", user=" + user +
                ", sort=" + sort +
                '}';
    }
}