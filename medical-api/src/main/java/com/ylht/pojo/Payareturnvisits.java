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
public class Payareturnvisits implements Serializable {
    private Integer pid;
    private String pname;
    private String way;
    private String describe;
    private Integer  operator;
    private Date writetime;
    private Integer aftertype;
    private String mname;
}
