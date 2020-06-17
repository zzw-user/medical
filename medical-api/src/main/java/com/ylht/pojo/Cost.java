package com.ylht.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Cost  implements Serializable {
    private Integer cid;
    private Integer operator;
    private String address;
    private String cost;
    private String dataentryclerk;
    private Date inputtime;
    private Integer aid;
    private Integer pid;
    private String phone;
}
