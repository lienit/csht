package com.java.csht.model;

public class RecAddress {
    private Integer id;

    private String consignee;

    private String incampus;

    private String dataaddress;

    private String mobile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    public String getIncampus() {
        return incampus;
    }

    public void setIncampus(String incampus) {
        this.incampus = incampus == null ? null : incampus.trim();
    }

    public String getDataaddress() {
        return dataaddress;
    }

    public void setDataaddress(String dataaddress) {
        this.dataaddress = dataaddress == null ? null : dataaddress.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }
}