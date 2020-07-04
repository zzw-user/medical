package com.ylht.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Areafaultanalysis {
    private Integer fid;
    private Integer faulttypeid;
    private String faultdescription;
    private Integer aid;
    private String faulttype;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date installationtime;
    private String analyze;
    private String dname;
    private Integer did;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFaulttypeid() {
        return faulttypeid;
    }

    public void setFaulttypeid(Integer faulttypeid) {
        this.faulttypeid = faulttypeid;
    }

    public String getFaultdescription() {
        return faultdescription;
    }

    public void setFaultdescription(String faultdescription) {
        this.faultdescription = faultdescription;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getFaulttype() {
        return faulttype;
    }

    public void setFaulttype(String faulttype) {
        this.faulttype = faulttype;
    }

    public Date getInstallationtime() {
        return installationtime;
    }

    public void setInstallationtime(Date installationtime) {
        this.installationtime = installationtime;
    }

    public String getAnalyze() {
        return analyze;
    }

    public void setAnalyze(String analyze) {
        this.analyze = analyze;
    }


}
