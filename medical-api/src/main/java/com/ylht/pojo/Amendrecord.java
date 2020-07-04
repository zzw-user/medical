package com.ylht.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Transient;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Amendrecord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;
    private Integer operator;
    private String address;
    private String beforeinstallation;
    private String afterinstallation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date installationtime;
    @Column(name = "`status`")
    private Integer status;
    private String arpartcoding;
    private String assess;
    @Column(name="`analyze`")
    private String analyze;
    private Integer did;
    private String faulttype;
    private String faultdescription;
    private String productcoding;
    @Transient
    private String realname;
    @Transient
    private String moperator;//操作人员姓名
}
