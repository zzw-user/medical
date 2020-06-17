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
public class Orderform  implements Serializable {
    private Integer oid;
    private String serialnumber;
    private Integer operator;
    private String coding;
    private String buyerphone;
    private String buyeraddress;
    private float saleprice;
    private Date selldatedatetime;
}
