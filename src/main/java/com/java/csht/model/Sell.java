package com.java.csht.model;

public class Sell {
    private Integer sid;

    private String sname;

    private Float sprice;

    private Float ssellprice;

    private String cog;

    private String sdep;

    private String smobile;

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

    public String getCog() {
        return cog;
    }

    public void setCog(String cog) {
        this.cog = cog == null ? null : cog.trim();
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
}