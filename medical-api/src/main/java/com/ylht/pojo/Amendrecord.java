package com.ylht.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Amendrecord implements Serializable {
    private Integer rid;
    private Integer operator;
    private String address;
    private String beforeinstallation;
    private String afterinstallation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date installationtime;
    private Integer status;
    private String arpartcoding;
    private String assess;
    private String analyze;
    private Integer did;
    private String faulttype;
    private String faultdescription;
    private String productcoding;
    @Transient
    private String moperator;//操作人员姓名
}
