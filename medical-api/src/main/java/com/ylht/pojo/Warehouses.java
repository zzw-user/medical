package com.ylht.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Warehouses implements Serializable {
    private Integer wid;
    private String wname;
    private String address;
    private Integer pid;
    private Date creationtime;
    private String mname;
}
