package com.ylht.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Installrecord  implements Serializable {
    @Id
    private Integer rid;
    private Integer operator;
    private String address;
    private String beforeinstallation;
    private String afterinstallation;
    private Date installationtime;
    private String assess;
    private Integer status;
    private String coding;
    @Transient
    private String moperator;//操作人员姓名
}
