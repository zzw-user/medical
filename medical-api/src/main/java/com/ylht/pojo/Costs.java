package com.ylht.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Costs {
    private Integer cid;
    private Integer operator;
    private String address;
    private String cost;
    private String sparepartcost;
    private String dataentryclerk;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date inputtime;
    private Integer aftertype;
    private String coding;
    private String phone;
    private String mname;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getSparepartcost() {
        return sparepartcost;
    }

    public void setSparepartcost(String sparepartcost) {
        this.sparepartcost = sparepartcost;
    }

    public String getDataentryclerk() {
        return dataentryclerk;
    }

    public void setDataentryclerk(String dataentryclerk) {
        this.dataentryclerk = dataentryclerk;
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }


    public Integer getAftertype() {
        return aftertype;
    }

    public void setAftertype(Integer aftertype) {
        this.aftertype = aftertype;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
}
