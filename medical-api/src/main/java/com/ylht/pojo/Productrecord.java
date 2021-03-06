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
public class Productrecord  implements Serializable {
     private Integer aid;
     private Integer pid;
     private Integer operator;
     private Integer operationtype;
     private Integer quantity;
     private Date operationtime;

}
